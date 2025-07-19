# 🎨 Ghibli Art Generator

A magical art generator that produces **Ghibli-style** visuals using **Stability AI's image generation API**.  
Built with a modern stack:

- ⚛️ **Frontend**: React.js  
- ☕ **Backend**: Spring Boot (Java)  
- 🧠 **AI API**: Stability AI (DreamStudio)

---

## ✨ What It Does

Enter a prompt, and the app generates a beautiful **Studio Ghibli-inspired image** powered by **Stability AI**.

---

## 🛠️ Tech Stack

| Layer      | Technology          |
|------------|---------------------|
| Frontend   | React.js            |
| Backend    | Spring Boot         |
| AI API     | Stability AI (DreamStudio) |
| Styling    | CSS / Tailwind / etc. (your choice)

---

## 🚀 How to Run the App

### 🔧 Option 1: Run Locally (React + Spring Boot)

#### 1. Stability AI API Key
You'll need an API key from Stability AI:
- Sign up at [https://platform.stability.ai](https://platform.stability.ai)
- Go to the **API Keys** section and generate a key
- Add the key to your Spring Boot backend in an `.env` or `application.properties` file:

```properties
STABILITY_API_KEY=your_api_key_here
