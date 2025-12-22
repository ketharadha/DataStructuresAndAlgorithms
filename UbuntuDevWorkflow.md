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

Nice — that’s a smart move.
Below is a **clean, copy-paste-ready checklist** you can drop straight into your **dev workflow README**.

It reflects **exactly what you’ve set up**, using **Tailscale + IP-based ACLs + SSH + Remote Desktop prep**, and explains **why** each step exists.

---

# Remote Access to Home Linux Server (CGNAT-safe)

This setup enables secure remote access from a Windows laptop to a home Linux server behind CGNAT using Tailscale.

---

## 1. Install and configure Tailscale on the Linux server

```bash
curl -fsSL https://tailscale.com/install.sh | sh
sudo tailscale up
```

**Why:**
Creates a secure, encrypted, private network interface (`tailscale0`) that works without a public IP or port forwarding.

---

## 2. Verify Linux server is connected to Tailscale

```bash
tailscale status
tailscale ip -4
```

**Why:**
Confirms the Linux server has successfully joined the Tailscale network and obtained a stable private IP (`100.x.x.x`).

---

## 3. Install and enable SSH server on Linux

```bash
sudo apt update
sudo apt install openssh-server
sudo systemctl enable ssh
sudo systemctl start ssh
```

**Why:**
Allows the Linux server to accept incoming remote connections over SSH.

---

## 4. Confirm SSH is listening on all interfaces

```bash
sudo ss -tlnp | grep :22
```

**Why:**
Ensures SSH is reachable over the Tailscale interface and not restricted to localhost or LAN only.

---

## 5. Verify firewall is not blocking connections

```bash
sudo ufw status
```

**Why:**
Confirms no local firewall rules are blocking inbound traffic (UFW inactive).

---

## 6. Install Tailscale on the Windows laptop

* Download from: [https://tailscale.com/download/windows](https://tailscale.com/download/windows)
* Sign in with the same Tailscale account

```powershell
tailscale status
```

**Why:**
Adds the Windows laptop to the same private network so it can reach the Linux server securely.

---

## 7. Verify connectivity from Windows to Linux

```powershell
tailscale ping <linux-tailscale-ip>
```

**Why:**
Confirms encrypted network connectivity between the Windows laptop and the Linux server.

---

## 8. Connect to Linux server via SSH from Windows

```powershell
ssh <linux-username>@<linux-tailscale-ip>
```

**Why:**
Provides reliable remote terminal access to the Linux server for development and administration.

---

## 9. Configure Tailscale ACLs (IP-based, all ports allowed)

```json
{
  "acls": [
    {
      "action": "accept",
      "src": ["<your-email@example.com>"],
      "dst": ["100.xx.xxx.xxx:*"]
    }
  ]
}
```

**Why:**
Explicitly allows all traffic from the authenticated user to the Linux server, preventing ACL-related connection timeouts.

---

## 10. Prepare Linux server for remote desktop (GUI access)

```bash
sudo apt install ubuntu-desktop-minimal
```

**Why:**
Installs a lightweight desktop environment required for graphical remote access tools.

---

## 11. (Optional) Attempted NoMachine remote desktop setup

* NoMachine server installed on Linux
* NoMachine client installed on Windows
* Encountered compatibility issues on Ubuntu 26.04

**Why:**
Explored high-performance remote desktop access over Tailscale; noted instability on development Ubuntu releases.

---

## 12. Final verified working access paths

| Access Type        | Status                                   |
| ------------------ | ---------------------------------------- |
| Tailscale network  | ✅ Working                                |
| SSH over Tailscale | ✅ Working                                |
| ACL enforcement    | ✅ Working                                |
| GUI remote desktop | ⚠️ Optional / pending (XRDP recommended) |

---

## Key design decisions

* **Tailscale instead of port forwarding** → Secure, CGNAT-safe access
* **IP-based ACLs** → Simple and explicit control during initial setup
* **SSH as primary access** → Stable, lightweight, and dev-friendly
* **GUI optional** → Avoids instability on bleeding-edge Ubuntu

---

## Recommended next improvements (future)

* Replace IP-based ACLs with machine names or tags
* Switch to XRDP if GUI access is required
* Enable SSH key-based authentication
* Lock SSH to Tailscale interface only
* Add MagicDNS for hostname-based access

---
