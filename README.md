<div align="center">
  <img width="200" height="200" alt="ico" src="https://github.com/user-attachments/assets/98170af6-a310-4c18-892a-3edb2e33bb9b" />
</div>

<h1 align="center">Salon Nipuni — Back Office API</h1>

<p align="center">
  The system that runs the back office of <b>Salon Nipuni</b> — bookings, clients, stylists, finance and a little AI assistant, wrapped into one Spring Boot API.
</p>

<p align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=20&duration=2800&pause=900&color=B8860B&center=true&vCenter=true&width=560&lines=Built+by+Nipuni+Nilsha;A+self-taught+full-stack+project;Spring+Boot+%2B+MySQL+%2B+Vanilla+JS;Still+growing%2C+one+feature+at+a+time" alt="typing banner" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/Auth-JWT-black?logo=jsonwebtokens&logoColor=white">
  <img src="https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white">
</p>

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=120&section=header" width="100%">
</p>

---

### Hey 👋

I'm Nipuni. This is the back-office system I built for **Salon Nipuni** — I wanted the salon to stop running on WhatsApp messages and a notebook, so I put together an actual booking + client + finance system for it. It started as a way to practice Spring Boot properly and slowly turned into something I could actually hand over to the staff and use every day.

It's not a tutorial project — every module here exists because the salon genuinely needed it (chasing no-shows, tracking loyalty points, working out who cancelled what and why, etc). Still adding to it whenever I find time.

<br/>
<img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="1000">
<br/>

## What it actually does

I split it roughly into four areas:

**Front desk work** — booking creation & cancellations, opening/closing the front-desk shift, client records with loyalty tiers (Silver → Gold → Diamond), and promo codes that show a live discount preview before you apply them.

**Salon catalog** — stylists, services (grouped by Hair Studio / Skin & Beauty / Nails Bar / Bridal Studio), bridal packages in three tiers, plus the gallery and testimonials shown on the public site.

**Money side** — expense logging, and income/expense reports that can be pulled as JSON for the dashboard or exported straight to PDF for whoever needs the paperwork.

**Behind the scenes** — JWT + OTP login, role-based access (admin / manager / receptionist), a full activity log so nothing happens silently, and a small AI chat widget that can answer questions using the salon's own data.

<br/>

## Stack

| | |
|---|---|
| **Backend** | Java 21, Spring Boot 4.1 (Web, Data JPA, Security, Validation, Mail) |
| **Database** | MySQL |
| **Auth** | JWT (`io.jsonwebtoken`) |
| **Reports/Files** | Apache POI for Excel, PDFBox for the PDF reports |
| **AI** | Claude or Gemini — swappable, see below |
| **Frontend** | Plain HTML/CSS/JS dashboard, no framework (`src/main/resources/static`) |

I kept the frontend framework-free on purpose — wanted to actually understand what a framework abstracts away before reaching for React on the next project.

<br/>

## Running it locally

You'll need Java 21 and a local MySQL instance.

```bash
git clone https://github.com/<your-username>/salon-nipuni-api.git
cd salon-nipuni-api
```

The schema creates itself on first run (`ddl-auto=update` + `createDatabaseIfNotExist`), so there's no migration script to run manually — just make sure MySQL is up.

If your MySQL root password isn't the default, override it with an env var instead of editing the properties file:

```bash
DB_USERNAME=root DB_PASSWORD=1234 ./mvnw spring-boot:run
```

Once it's up, the API sits on `http://localhost:8080` and the dashboard is served from the same address at `http://localhost:8080/index.html`.

**Login (seeded on first run):**

| Username | Password |
|---|---|
| `nipuni` | `nipuni123` |

<br/>

## Configuration

Everything lives in `application.properties`, overridable via env vars so I never have to commit real secrets:

| Variable | What it's for | Default |
|---|---|---|
| `DB_USERNAME` / `DB_PASSWORD` | MySQL login | `root` / `mysql` |
| `JWT_SECRET` | Signs the auth tokens | pre-set, change it before deploying anywhere real |
| `MAIL_HOST` / `MAIL_USERNAME` / `MAIL_PASSWORD` | SMTP for booking + low-stock alerts | Gmail SMTP |
| `SALON_WHATSAPP_NUMBER` | Number the "Confirm via WhatsApp" button links to | — |
| `AI_CHAT_ENABLED` | Turn the chat widget on/off | `true` |
| `AI_CHAT_PROVIDER` | `anthropic` or `gemini` | `gemini` |
| `ANTHROPIC_API_KEY` / `GEMINI_API_KEY` | Whichever provider you pick | — |

> One honest note to self: the properties file currently has real-looking mail and Gemini keys checked in from testing. Rotating those and moving them to a proper `.env` (git-ignored) is next on the list before this repo goes fully public.

<br/>

## API, roughly

Everything sits under `/v1`. Quick map of what's where:

```
/v1/auth              login, OTP, forgot-password flow
/v1/booking           create / place bookings, receipts
/v1/return            cancellations
/v1/client            client records
/v1/stylist           stylist records
/v1/salonService       service catalog + image upload
/v1/bridalPackage     bridal packages
/v1/promoCode          promo codes + live preview
/v1/expense            salon expenses
/v1/report              income & expense reports (JSON + PDF)
/v1/frontDeskShift     open / close shift
/v1/gallery              gallery images
/v1/testimonial         testimonials
/v1/performance         receptionist performance
/v1/export               Excel exports
/v1/activity              audit log
/v1/chat                  AI assistant
/v1/user                  staff accounts
```

Full request/response shapes are in the DTOs under `service/dto` if you want the details rather than guessing from the endpoint name.

<br/>

## The AI widget

Probably the part I had the most fun building. The chat provider is behind an interface, so the rest of the app has no idea whether it's talking to Claude or Gemini:

```
ChatController → ChatService → ChatProvider
                                  ├── AnthropicChatProvider
                                  ├── GeminiChatProvider
                                  └── FallbackChatProvider   (no key configured)
```

Switching providers is just one property. If neither key is set, `/v1/chat` just tells you it isn't configured instead of throwing a 500 — small thing, saved me a lot of confused debugging early on.

<br/>

## Still on the list

- [ ] Hook this up to an actual public booking site instead of just the internal dashboard
- [ ] SMS reminders alongside email/WhatsApp
- [ ] Support more than one branch
- [ ] Get it running in Docker so setup isn't "install MySQL and pray"

<br/>

<div align="center">

<img src="https://user-images.githubusercontent.com/74038190/216122041-518ac897-8d92-4c6b-9b3f-ca01dcaf38ee.png" width="100">

_Built and maintained by 💛 **Nipuni Nilsha** for Salon Nipuni._

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=100&section=footer" width="100%">

</div>
