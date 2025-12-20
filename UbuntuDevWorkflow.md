# Ubuntu 26.04 – Software Development Engineer Workflow

This document describes a **modern, reproducible, AI-assisted development environment** for Software Development Engineers using **Ubuntu 26.04**.

The goal is:
- Fast local development
- Clean, reproducible environments
- Strong terminal + editor ergonomics
- Built-in support for AI coding assistants
- Minimal OS-level clutter

---

## 1. System Update & Core Build Tools

```bash
sudo apt update && sudo apt -y upgrade
````

**Why:** Ensures the OS is secure, stable, and compatible with modern tooling.

```bash
sudo apt install -y \
  build-essential \
  curl \
  wget \
  git \
  unzip \
  zip \
  ca-certificates \
  gnupg \
  lsb-release
```

**Why:**

* `build-essential` → compile native dependencies
* `curl/wget` → fetch install scripts & APIs
* `git` → version control backbone
* `ca-certificates/gnupg` → secure package verification

---

## 2. Developer CLI Productivity Tools

```bash
sudo apt install -y \
  ripgrep \
  fzf \
  bat \
  tmux \
  jq \
  tree \
  htop
```

**Why each tool matters:**

* `ripgrep (rg)` → ultra-fast codebase search
* `fzf` → fuzzy-find files, commands, git branches
* `bat` → readable `cat` with syntax highlighting
* `tmux` → persistent terminal sessions per project
* `jq` → parse & inspect JSON APIs quickly
* `tree` → visualize repo structure
* `htop` → monitor system & runaway processes

> On Ubuntu, `bat` may be installed as `batcat`:

```bash
echo "alias bat=batcat" >> ~/.bashrc
```

---

## 3. Zsh Shell + Starship Prompt

```bash
sudo apt install -y zsh
chsh -s "$(which zsh)"
```

**Why:** Zsh offers better completions, plugins, and scripting than bash.

### Install Starship Prompt

```bash
curl -sS https://starship.rs/install.sh | sh
echo 'eval "$(starship init zsh)"' >> ~/.zshrc
```

**Why:**
Starship provides a fast, informative prompt (git status, runtime versions, errors) without slowing the shell.

Log out and back in to activate Zsh.

---

## 4. Git Configuration (Required)

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --global init.defaultBranch main
git config --global pull.rebase true
git config --global rebase.autoStash true
git config --global fetch.prune true
```

**Why:**

* Clean git history
* Safe rebasing by default
* Prevents stale remote branches

---

## 5. SSH Keys for Git Hosting (GitHub / GitLab)

```bash
ssh-keygen -t ed25519 -C "you@example.com"
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
cat ~/.ssh/id_ed25519.pub
```

**Why:**
Secure, passwordless authentication for pushing and pulling repositories.

Add the printed public key to your Git hosting provider.

---

## 6. Visual Studio Code (Primary IDE)

Install VS Code via Ubuntu Software or official `.deb`.

### Required Extensions

* **GitHub Copilot** → AI code completion & chat
* **Dev Containers** → reproducible dev environments
* **Docker** → container integration
* Language-specific extensions (Python, Go, Rust, Node, etc.)
* **Prettier / ESLint** → formatting & linting

**Why VS Code:**
Best balance of speed, extensibility, AI support, and container workflows.

---

## 7. Docker Engine (Reproducible Environments)

```bash
sudo apt install -y docker.io docker-compose
sudo usermod -aG docker "$USER"
newgrp docker
```

Verify:

```bash
docker run hello-world
```

**Why:**
Docker ensures:

* identical dev environments across machines
* “works on my machine” problems disappear
* CI mirrors local execution

---

## 8. Recommended Project Structure

```text
~/dev/
├── work/
├── personal/
├── open-source/
└── experiments/
```

Each repository should contain:

* `README.md`
* `.gitignore`
* `.env.example`
* `Makefile`
* `.devcontainer/` (if containerized)

**Why:**
Consistency reduces cognitive load and onboarding time.

---

## 9. Dev Containers (Strongly Recommended)

Each project defines its own environment using `.devcontainer/`.

Example structure:

```text
.devcontainer/
├── devcontainer.json
└── Dockerfile
```

**Why:**

* New developer → open repo → start coding
* No global dependency conflicts
* Perfect for teams and long-lived projects

---

## 10. Standard Makefile Interface

Every repo should support these commands:

```bash
make setup   # install dependencies
make test    # run tests
make lint    # static analysis
make run     # run application
make ci      # what CI runs
```

**Why:**
A single, predictable interface keeps local dev and CI aligned.

---

## 11. Coding Assistant Workflow

### Recommended Setup

* **GitHub Copilot** → inline suggestions & refactors
* **ChatGPT** → architecture, debugging, test strategies

### Best Uses for AI

* Boilerplate generation
* Writing tests from specs
* Refactoring & code cleanup
* Explaining unfamiliar code
* Drafting documentation

### Still Your Responsibility

* Architecture decisions
* Security & performance review
* Final code correctness

---

## 12. Mental Model (Important)

* The terminal is your control plane
* The editor is for thinking & writing
* Containers provide isolation
* Automation beats manual steps
* Small commits, frequent tests, clean history

---

## 13. End State

After completing this README, you will have:

* A clean Ubuntu-based SDE environment
* Fast terminal-driven workflows
* AI-assisted coding inside your editor
* Reproducible, team-friendly setups
* A system that scales with real-world software projects

---

**Welcome to Linux-first software development.**

```

---
