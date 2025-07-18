# 🧬 AtomicBioReader - Sistema de Cadastro Biométrico

<p align="center">
  <img src="https://img.shields.io/badge/Java-8%2B-blue?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/Swing-GUI-green?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Desktop%20App-Java%20Swing-blueviolet?style=for-the-badge"/>
</p>

<div align="center">
  <b>🇧🇷 Português | <a href="#english-version">🇺🇸 English below</a></b>
</div>

---

## 📑 Sumário | Table of Contents
- [Sobre o Projeto | About](#sobre-o-projeto--about)
- [Tecnologias | Technologies](#tecnologias--technologies)
- [Estrutura | Structure](#estrutura--structure)
- [Execução | Running](#execução--running)
- [Funcionalidades | Features](#funcionalidades--features)
- [Modelos e Interfaces | Models & Interfaces](#modelos-e-interfaces--models--interfaces)
- [Autor | Author](#autor--author)

---

## Sobre o Projeto | About

**PT-BR:**
> Sistema desktop Java Swing para cadastro e verificação biométrica de digitais, utilizando dispositivos compatíveis com a biblioteca CIDBio. Permite capturar, salvar, verificar e identificar digitais, além de gerenciar informações de médicos.

**EN:**
> Java Swing desktop system for biometric fingerprint registration and verification, using devices compatible with the CIDBio library. Allows capturing, saving, verifying, and identifying fingerprints, as well as managing doctor information.

---

## 🚀 Tecnologias | Technologies
- Java 8+
- Java Swing (GUI)
- Biblioteca CIDBio (integração com leitor biométrico)

---

## 🗂️ Estrutura | Structure
```
java_cadbio_reader/
├── build.xml
├── manifest.mf
├── src/
│   └── atomicbio/
│       ├── AtomicBioReader.java         # Lógica de leitura/verificação biométrica
│       ├── jfPrincipal.java             # Interface gráfica principal
│       ├── Main.java                    # Ponto de entrada do sistema
│       ├── interfaces/
│       │   ├── BaseCrud.java            # Interface CRUD genérica
│       │   └── Prestador.java           # Interface para prestadores (ex: médicos)
│       └── models/
│           └── Medicos.java             # Modelo de dados para médicos
└── README.md
```

---

## ⚙️ Execução | Running

**PT-BR:**
1. **Pré-requisitos:** Java 8+ instalado.
2. **Compilação:**
   - Use o comando abaixo na raiz do projeto:
     ```bash
     javac -cp "caminho/para/CIDBio.jar" -d build/ src/atomicbio/*.java src/atomicbio/interfaces/*.java src/atomicbio/models/*.java
     ```
3. **Execução:**
   - Execute o sistema:
     ```bash
     java -cp "build;src;Caminho/para/CIDBio.jar" atomicbio.Main
     ```
   - O sistema abrirá a interface gráfica para cadastro biométrico.

**EN:**
1. **Prerequisites:** Java 8+ installed.
2. **Compile:**
   - Use the command below in the project root:
     ```bash
     javac -cp "path/to/CIDBio.jar" -d build/ src/atomicbio/*.java src/atomicbio/interfaces/*.java src/atomicbio/models/*.java
     ```
3. **Run:**
   - Run the system:
     ```bash
     java -cp "build;src;path/to/CIDBio.jar" atomicbio.Main
     ```
   - The graphical interface for biometric registration will open.

---

## 🖥️ Funcionalidades | Features
- **PT-BR:**
  - Captura e exibição de digitais via leitor biométrico
  - Geração e verificação de templates biométricos
  - Identificação de pessoas por digital
  - Cadastro e gerenciamento de médicos (modelo de exemplo)
- **EN:**
  - Capture and display fingerprints via biometric reader
  - Generation and verification of biometric templates
  - Person identification by fingerprint
  - Doctor registration and management (example model)

---

## 🧩 Modelos e Interfaces | Models & Interfaces
- `AtomicBioReader.java`: Lógica de captura, verificação e identificação biométrica.
- `jfPrincipal.java`: Interface gráfica principal (Swing), integra com o leitor biométrico.
- `Main.java`: Inicializa a interface principal.
- `models/Medicos.java`: Exemplo de modelo de dados para médicos, implementa interface `Prestador`.
- `interfaces/BaseCrud.java`: Interface genérica para operações CRUD.
- `interfaces/Prestador.java`: Interface para entidades do tipo prestador (ex: médicos).

---

## 👤 Autor | Author

<div align="center">
  <b>Feito com 💙 para estudos de Java, Swing e biometria.<br/>
  Made with 💙 for Java, Swing and biometrics studies.</b>
</div>

---

<div align="center" id="english-version">
  <b>🇺🇸 English version above | <a href="#top">🇧🇷 Versão em português acima</a></b>
</div>