# NGrams Project

This project analyzes word frequency data from Google Books Ngram dataset, allowing users to track the usage of words over time and visualize their trends.

## Project Structure

```
NGrams/
├── data/
│   └── ngrams/          # Contains data files (CSV format)
├── lib/                 # External dependencies
├── src/                 # Source code
│   ├── browser/        # Web interface components
│   ├── main/           # Main application code
│   ├── ngrams/         # Core N-gram analysis code
│   ├── plotting/       # Data visualization
│   └── utils/          # Utility functions
├── static/             # Web interface static files
└── tests/              # Unit tests
```

## Required Data Files

The following data files are required to run the project:
- `total_counts.csv`
- `very_short.csv`
- `less_short.csv`
- `words_that_start_with_q.csv`
- `frequency-EECS.csv`

Large data files (not included in repository):
- `top_14377_words.csv`
- `top_49887_words.csv`

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/ethanzhanghello/NGrams.git
   cd NGrams
   ```

2. Add the required large data files to the `data/ngrams/` directory:
   - `top_14377_words.csv`
   - `top_49887_words.csv`

3. Open the project in IntelliJ IDEA:
   - File -> Open -> Select the NGrams directory
   - IntelliJ will recognize it as a project and set up the dependencies

4. Run the project:
   - The main entry point is `src/main/Main.java`
   - Run the main method to start the web server
   - Visit http://localhost:4567/ngordnet_2a.html in your browser

## Features

- Track word frequency over time
- Visualize word usage trends
- Compare multiple words
- Web interface for easy interaction
- Support for various time ranges

## Dependencies

The project uses several libraries (included in the `lib/` directory):
- Princeton's algs4 library
- JUnit for testing
- XChart for plotting
- Spark for web server
- SLF4J for logging
- Gson for JSON handling

## Testing

Run the tests using JUnit:
```bash
javac -cp ".:lib/*" tests/*.java
java -cp ".:lib/*" org.junit.platform.console.ConsoleLauncher --scan-classpath
``` 