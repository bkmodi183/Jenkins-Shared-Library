# Jenkins Shared Library

A **Jenkins Shared Library** to provide reusable pipeline steps, helper classes, and templates for standardizing Jenkins pipelines across projects.

---

## Repository Structure

(root)
├── vars/           # Global steps/functions callable from Jenkinsfiles
│   └── example.groovy
├── src/            # Groovy classes with packages
│   └── org/example/Helper.groovy
└── resources/      # Templates and static resources
    └── myTemplate.txt

**Explanation:**

- `vars/` – Contains `.groovy` files defining pipeline **steps/functions** callable directly from Jenkinsfiles.  
- `src/` – Contains **Groovy classes** for reusable logic.  
- `resources/` – Contains **static files**, such as templates, accessible from pipeline scripts.

---

## Setup in Jenkins

### Step 1: Configure the Shared Library

1. Open Jenkins → **Manage Jenkins → Configure System**  
2. Scroll to **Global Pipeline Libraries** → Click **Add**  
3. Fill in the fields:
   - **Name:** `my-shared-library` (used in Jenkinsfiles)  
   - **Default version:** `main` (or your branch)  
   - **Retrieval method:** `Modern SCM` → Git  
   - **Repository URL:** `https://github.com/YOUR_USERNAME/YOUR_REPO.git`  
   - **Credentials:** Add GitHub credentials or token if private  
4. Click **Save**  

---

### Step 2: Use the Library in a Jenkinsfile

At the top of your Jenkinsfile, import the library:

```groovy
**@Library('my-shared-library') _**
pipeline {
    agent any
    stages {
        stage('Test Shared Library') {
            steps {
                example()
            }
        }
    }
}

Step 3: Example Shared Library Step

def call(String name = "World") {
    echo "Hello, ${name} from the shared library!"
}

Call it in your pipeline: example("Jenkins")

Output: Hello, Jenkins from the shared library!

**Tips**

* Version your library carefully (use branches or tags).
* Test new functions in a sandbox pipeline before production use.
* Document new steps in vars/ with comments for other developers.
