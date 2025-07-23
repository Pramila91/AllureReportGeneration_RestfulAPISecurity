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

Happy Testing 🚀
