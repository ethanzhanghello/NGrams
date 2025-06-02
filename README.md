# 📊 N-Grams Time Series Analyzer (Java)

## 📌 Table of Contents

- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [Installation Instructions](#installation-instructions)
- [Usage Instructions](#usage-instructions)
- [Documentation](#documentation)
- [Visuals](#visuals)
- [Project Roadmap](#project-roadmap)
- [Contribution Guidelines](#contribution-guidelines)
- [License Information](#license-information)

---

## 📖 Project Description

This is a Java-based application that mimics Google’s Ngram Viewer. It analyzes historical word usage trends using large datasets and plots the frequency of terms over time. Users can query word(s) and observe their linguistic trends in a dynamic, visual interface.

---

## 💻 Technologies Used

- Java 8+
- AWT & Swing for visual plotting
- Java Collections API
- Custom HTTP server and request handlers

---

## 📋 Requirements

- Java JDK 8 or later
- A Java IDE like IntelliJ or Eclipse
- N-Gram datasets in CSV format (word count and total counts per year)

---

## ⚙️ Installation Instructions

```bash
git clone https://github.com/your-username/ngrams-analyzer.git
cd ngrams-analyzer
```

Then open in your IDE, ensure all files are in the same package, and run `NgordnetServer.java`.

---

## 🕹️ Usage Instructions

- Start the server: run `NgordnetServer.java`
- Open browser and visit: `http://localhost:4567`
- Use a URL query like:
  ```
  /ngordnet?words=peace,war&startYear=1900&endYear=2000
  ```
- View a line graph comparing historical frequencies.

---

## 📚 Documentation

All core components are modularized:
- `NGramMap.java` – Loads and queries the dataset
- `TimeSeries.java` – Models year-to-frequency mappings
- `NgordnetQueryHandler.java` – Parses URL input and routes requests
- `Plotter.java` – Renders output as plots

---

## 🖼️ Visuals

*(Include screenshots of plotted results or UI once available)*

---

## 🗺️ Project Roadmap

- ✅ Plot word trends by year
- 🔄 Add multi-word plotting on one graph
- 🔜 Include CSV upload interface for custom datasets

---

## 🤝 Contribution Guidelines

Contributions are welcome! Please:
1. Fork the repo
2. Create a new branch
3. Submit a pull request with a clear description
4. Follow JavaDoc and existing code conventions

---

## 📜 License Information

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more information.
