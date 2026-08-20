<div align="center">

<img src="docs/logo.png" alt="Salon Nipuni Logo" width="220"/>

<h1>💇‍♀️ Salon Nipuni — Back Office API</h1>

<p><i>A complete salon management system for Salon Nipuni — bookings, clients, stylists, finance & an AI front-desk assistant, all in one Spring Boot API.</i></p>

<a href="https://git.io/typing-svg">
  <img src="https://readme-typing-svg.demolab.com?font=Poppins&size=22&duration=3000&pause=1000&color=D4AF37&center=true&vCenter=true&width=650&lines=Booking+%26+Client+Management;Stylist+%26+Front+Desk+Operations;Finance+%26+Performance+Reports;AI-Powered+Chat+Assistant+%F0%9F%A4%96" alt="Typing SVG" />
</a>

<br/>

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/Auth-JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

![Status](https://img.shields.io/badge/status-active-success?style=flat-square)
![License](https://img.shields.io/badge/license-Private-lightgrey?style=flat-square)

</div>

---

## ✨ Overview

**Salon Nipuni API** is the backend that powers **Salon Nipuni's** internal back-office dashboard — the system staff use every day to manage bookings, clients, stylists, bridal packages, promo codes, expenses, income reports and more. It also ships with a lightweight **vanilla-JS admin dashboard** (served as static files) and a built-in **AI chat assistant** (Anthropic Claude or Google Gemini) that can answer questions and even use tools against the live data.

> 🇱🇰 Built with care for **Salon Nipuni**, by **Nipuni Nilsha**.

<div align="center">
<img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="500">
</div>

---

## 📚 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Configuration](#-configuration)
- [API Endpoints](#-api-endpoints)
- [Roles & Access](#-roles--access)
- [AI Chat Assistant](#-ai-chat-assistant)
- [Roadmap](#-roadmap)
- [Author](#-author)

---

## 🚀 Features

<table>
<tr>
<td width="50%" valign="top">

### 📅 Front Desk
- Booking creation, placement & cancellations
- Front desk shift open/close tracking
- Client management with loyalty tiers (Silver / Gold / Diamond)
- Promo codes (percentage & fixed) with live preview

</td>
<td width="50%" valign="top">

### 💼 Business Operations
- Stylist & salon service catalog (with image upload)
- Bridal packages (Gold / Platinum / Diamond tiers)
- Gallery & testimonial management
- Salon expense tracking

</td>
</tr>
<tr>
<td width="50%" valign="top">

### 📊 Reports & Insights
- Income & expense reports (JSON + downloadable PDF)
- Receptionist performance metrics
- Data export (bookings, services, clients) to Excel
- Full activity log / audit trail

</td>
<td width="50%" valign="top">

### 🔐 Security & AI
- JWT authentication with OTP-based login
- Forgot-password flow (find → verify → reset)
- Role-based access: Administrator / Manager / Receptionist
- AI chat assistant (Claude or Gemini) with tool-calling

</td>
</tr>
</table>

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 4.1.0 (Web MVC, Data JPA, Security, Validation, Mail) |
| **Database** | MySQL |
| **Auth** | JWT (`io.jsonwebtoken`) |
| **Docs / Files** | Apache POI (Excel), Apache PDFBox (PDF reports) |
| **AI** | Anthropic Claude API / Google Gemini API |
| **Frontend** | Static HTML/CSS/Vanilla JS dashboard (`src/main/resources/static`) |
| **Build Tool** | Maven (`mvnw`) |

---

## 📁 Project Structure

```
salon-nipuni-api/
├── src/main/java/com/salonnipuni/api/
│   ├── controller/        # REST controllers (v1/*)
│   ├── service/            # Business logic (+ impl/)
│   │   └── ai/              # Pluggable Claude / Gemini chat providers
│   ├── entity/             # JPA entities
│   ├── dto/                 # Request / response DTOs
│   ├── repository/         # Spring Data JPA repositories
│   ├── security/            # JWT filter, config, handlers
│   ├── enumeration/        # Roles, statuses, tiers
│   ├── exception/           # Global exception handling
│   └── config/               # Data seeder & web config
├── src/main/resources/
│   ├── application.properties
│   └── static/                # Admin dashboard (HTML/CSS/JS)
├── src/test/                 # Unit & integration tests
├── AUDIT_AND_FIXES.md
└── pom.xml
```

---

## ⚡ Getting Started

### Prerequisites
- ☕ Java 21+
- 🐬 MySQL 8+ running locally
- 📦 Maven (or use the bundled `./mvnw`)

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/salon-nipuni-api.git
cd salon-nipuni-api
```

### 2️⃣ Configure the database
MySQL will auto-create the schema on first run — just make sure MySQL is running and update credentials if needed (see [Configuration](#-configuration)).

### 3️⃣ Run the application
```bash
./mvnw spring-boot:run
```

The API will start on **`http://localhost:8080`** — and the admin dashboard is served from the same origin at `http://localhost:8080/index.html`.

### 4️⃣ Login
A demo admin account is seeded automatically on first run:

| Username | Password |
|---|---|
| `amg` | `amg123` |

---

## ⚙️ Configuration

All configuration lives in `src/main/resources/application.properties` and is overridable via environment variables:

| Variable | Purpose | Default |
|---|---|---|
| `DB_USERNAME` / `DB_PASSWORD` | MySQL credentials | `root` / `mysql` |
| `JWT_SECRET` | Secret used to sign JWTs | *(pre-set — change in production!)* |
| `MAIL_HOST` / `MAIL_USERNAME` / `MAIL_PASSWORD` | SMTP for booking & low-stock alerts | Gmail SMTP |
| `SALON_WHATSAPP_NUMBER` | WhatsApp number for booking confirmations | `94785245772` |
| `AI_CHAT_ENABLED` | Turns the AI chat widget on/off | `true` |
| `AI_CHAT_PROVIDER` | `anthropic` or `gemini` | `gemini` |
| `ANTHROPIC_API_KEY` / `GEMINI_API_KEY` | API keys for the chosen provider | *(empty)* |

> ⚠️ **Security note:** the checked-in `application.properties` currently contains real-looking mail and Gemini credentials. Before pushing this repo public, rotate those secrets and move them into environment variables or a `.env` file that's excluded via `.gitignore`.

---

## 🔌 API Endpoints

All endpoints are prefixed with `/v1`. A few highlights:

| Module | Base Path | Description |
|---|---|---|
| 🔑 Auth | `/v1/auth` | Login, OTP verification, forgot-password flow |
| 📅 Booking | `/v1/booking` | Create, place, list bookings & generate receipts |
| ↩️ Cancellations | `/v1/return` | Booking cancellations / returns |
| 👤 Clients | `/v1/client` | Client CRUD |
| ✂️ Stylists | `/v1/stylist` | Stylist CRUD |
| 💈 Salon Services | `/v1/salonService` | Service catalog + image upload |
| 👰 Bridal Packages | `/v1/bridalPackage` | Package CRUD |
| 🎟️ Promo Codes | `/v1/promoCode` | Promo CRUD + live preview |
| 💰 Expenses | `/v1/expense` | Salon expense tracking |
| 📈 Reports | `/v1/report` | Income / expense reports (JSON & PDF) |
| 🧑‍💼 Front Desk Shifts | `/v1/frontDeskShift` | Open/close shift tracking |
| 🖼️ Gallery | `/v1/gallery` | Gallery image CRUD |
| 💬 Testimonials | `/v1/testimonial` | Testimonial CRUD |
| 📊 Performance | `/v1/performance` | Receptionist performance metrics |
| 🗂️ Export | `/v1/export` | Excel export for bookings/services/clients |
| 📜 Activity Log | `/v1/activity` | Full audit trail |
| 🤖 Chat | `/v1/chat` | AI chat assistant |
| 👥 Users | `/v1/user` | Staff user management |

Full request/response contracts are defined via DTOs in `src/main/java/com/salonnipuni/api/dto`.

---

## 🛡 Roles & Access

| Role | Access |
|---|---|
| `ADMINISTRATOR` | Full access to every module |
| `MANAGER` | Operational + reporting access |
| `RECEPTIONIST` | Front-desk operations (bookings, clients, shifts) |

Loyalty tiers (`SILVER`, `GOLD`, `DIAMOND`) automatically apply checkout discounts based on client points.

---

## 🤖 AI Chat Assistant

The dashboard includes a chat widget backed by a **pluggable AI provider architecture**:

```
ChatController → ChatService → ChatProvider (interface)
                                   ├── AnthropicChatProvider
                                   ├── GeminiChatProvider
                                   └── FallbackChatProvider
```

Switch providers anytime via `app.ai.provider` — adding a new one only requires implementing `ChatProvider`; nothing else in the app needs to change. If no API key is configured, `/v1/chat` responds with a clear "not configured" message instead of failing.

---

## 🗺 Roadmap

- [ ] Public-facing booking website integration
- [ ] SMS notifications alongside email/WhatsApp
- [ ] Multi-branch support
- [ ] Dockerized deployment

---

## 👩‍💻 Author

<div align="center">

**Nipuni Nilsha**
Creator & Owner — Salon Nipuni

<img src="https://user-images.githubusercontent.com/74038190/216122041-518ac897-8d92-4c6b-9b3f-ca01dcaf38ee.png" width="100">

_Made with 💛 for Salon Nipuni_

</div>
