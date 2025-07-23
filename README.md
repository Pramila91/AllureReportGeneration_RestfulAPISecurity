# 🧪 Run TestNG Suite & Generate Allure Report in IntelliJ Terminal

A step-by-step guide to running TestNG test suites with Maven and generating Allure reports directly from the IntelliJ Terminal.

---

## 📦 1. Configure Your `pom.xml`

Ensure the following configuration is added to your `pom.xml`.

### ✅ Maven Surefire Plugin

```xml
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
    <configuration>
        <suiteXmlFiles>
            <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
        </suiteXmlFiles>
        <systemPropertyVariables>
            <allure.results.directory>target/allure-results</allure.results.directory>
        </systemPropertyVariables>
    </configuration>
</plugin>


### ✅ Default Test Suite Property (Optional)

```xml
<properties>
    <suiteXmlFile>testng_Allure_reporting.xml</suiteXmlFile>
</properties>
```

---

## 💻 2. Open IntelliJ Terminal

1. Open IntelliJ and load your Maven project.
2. Go to `View > Tool Windows > Terminal` or press `Alt + F12`.
3. Ensure you're in your project root (e.g., `D:\RestAssuredProjectRestfulAPI`).

---

## 🧹 3. Clean Previous Allure Results (Optional but Recommended)

### Using PowerShell:
```powershell
Remove-Item -Recurse -Force .\target\allure-results\*
```

### Using Command Prompt:
```cmd
rmdir /s /q target\allure-results
mkdir target\allure-results
```

---

## ▶️ 4. Run Your Tests Using Maven

### To run the default suite:
```bash
mvn test
```

### To run a specific TestNG suite XML file:
```bash
mvn test -DsuiteXmlFile="your_specific_suite.xml"
```

### Or with full path:
```bash
mvn test -DsuiteXmlFile="D:\RestAssuredProjectRestfulAPI\your_specific_suite.xml"
```

---

## 📊 5. Generate and View Allure Report

### a. Serve the report immediately:
```bash
allure serve target/allure-results
```
- Opens a local server in your browser.
- Closes when the browser is closed.

### b. Generate and open the report manually:

#### Generate the report:
```bash
allure generate target/allure-results --clean -o target/allure-report
```

#### Open the report:
```bash
allure open target/allure-report
```

---

## ⚠️ 6. Notes & Prerequisites

- **Allure CLI must be installed** and added to your system PATH.

### Check installation:
```bash
allure --version
```

### Install Allure on Windows (via Chocolatey):
```bash
choco install allure
```

- Ensure your test results are saved under:
  ```
  target/allure-results
  ```

- If no test results are generated, double-check:
  - `suiteXmlFile` path correctness
  - TestNG XML file structure

---

## 📁 Example Project Directory

```
RestAssuredProjectRestfulAPI/
│
├── pom.xml
├── testng_Allure_reporting.xml
├── /src
├── /target
│   ├── /allure-results
│   └── /allure-report
```

---

## ✅ You're now ready to automate with elegance and clarity using Allure Reports!

# 📊 Allure Report Cheatsheet (for IntelliJ + Maven + TestNG)

Quick reference for generating Allure reports with Maven, TestNG, and IntelliJ.

---

## 🧾 Commands and Descriptions

| 🔢 Step | 💻 Command | 📝 Description |
|--------|------------|----------------|
| 1 | `allure --version` | ✅ Check if Allure CLI is installed correctly and available in PATH |
| 2 | `choco install allure` | 📦 Installs Allure CLI via Chocolatey (Windows only) |
| 3 | `rmdir /s /q target\allure-results`<br>`mkdir target\allure-results` | 🧹 Deletes previous test results and recreates the results folder (CMD) |
| 4 | `Remove-Item -Recurse -Force .\target\allure-results\*` | 🧹 Same cleanup using PowerShell |
| 5 | `mvn test` | ▶️ Run default TestNG suite configured in `pom.xml` |
| 6 | `mvn test -DsuiteXmlFile="your_suite.xml"` | ▶️ Run a custom TestNG suite XML |
| 7 | `allure serve target/allure-results` | 📊 Instantly generate and serve the Allure report in your default browser; temporary server |
| 8 | `allure generate target/allure-results --clean -o target/allure-report` | 📁 Generate the static Allure report folder in `target/allure-report` |
| 9 | `allure open target/allure-report` | 🌐 Opens the generated Allure HTML report in the browser manually |
| 10 | `mvn clean` | 🧼 Clean the `target` directory (optional before new test run) |

---

## 💡 Quick Tips

- Always **clean old results** to avoid mixing new and old test outcomes.
- Allure report depends on test result XMLs created by **Surefire** plugin.
- If no report is generated:
  - ✅ Check that your `suiteXmlFile` is correct
  - ✅ Verify TestNG tests are executed
  - ✅ Ensure Surefire is configured to output to `target/allure-results`

---

