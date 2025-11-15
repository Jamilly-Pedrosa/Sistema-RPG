# ⚔️ RPG — Sistema com Design Patterns (Java)

Este projeto é um sistema simples de RPG desenvolvido em Java com foco na aplicação de padrões de projeto (**Factory**, **Strategy**, **Decorator**) e boas práticas de modularização.  
O usuário pode criar personagens, selecionar ataques, aplicar melhorias e iniciar um combate final.

## .✦ Estrutura do Projeto

| Pacote | Classes |
|--------|----------|
| **main** | `Main.java`, `Jogo.java`, `Combate.java` |
| **entidades** | `PersonagemAbstrato.java`, `Guerreiro.java`, `Mago.java`, `Inimigo.java` |
| **factory** | `PersonagemFactory.java` |
| **strategy** | `AtaqueStrategy.java`, `AtaqueFisico.java`, `AtaqueMagico.java` |
| **decorator** | `PersonagemDecorator.java`, `ArmaduraDecorator.java`, `PocaoDecorator.java`, `PocaoVida.java` |
| **util** | `ArquivoUtil.java`, `TratarErros.java` |

---

## .✦ Padrões de Projeto Utilizados

### **🏭 Factory – Criação de Personagens**
Centraliza a lógica de criação dos personagens, facilitando a manutenção e adição de novas classes.

**Classes relacionadas:**
- `PersonagemFactory`
- `Guerreiro.java`
- `Mago.java`

### **🎯 Strategy – Tipos de Ataque**
Permite alterar dinamicamente o ataque do personagem durante a execução.

**Classes relacionadas:**
- `AtaqueStrategy`
- `AtaqueFisico`
- `AtaqueMagico`

### **🛡 Decorator – Melhorias do Personagem**
Adiciona atributos extras ao personagem (como vida ou defesa) sem alterar sua classe principal.

**Classes relacionadas:**
- `PersonagemDecorator`
- `ArmaduraDecorator`
- `PocaoDecorator`
- `PocaoVida` 
---

## .✦ Funcionalidades

- Criar personagem  
- Carregar/selecionar personagens salvos  
- Escolher tipo de ataque  
- Equipar armadura (Decorator)  
- Usar poção de vida (Decorator)  
- Realizar combate com inimigo  
- Tratamento de erros ao ler entrada  
- Salvamento de personagens em arquivo  

---

## ➜ Fluxo para Jogar o Sistema

1. **Executar a classe `Main`**
2. Acessar **`[1] Menu Personagens`**  
   → Criar ou Selecionar um personagem
4. Acessar **`[3] Menu Melhorias`**  
   → Equipar armadura ou usar poção
5. Acessar **`[2] Menu Ataques`**  
   → Selecionar ataque físico ou mágico
6. Acessar **`[4] Iniciar Combate`**  
   → Sistema realiza o combate automaticamente

---

## ➜ Como Executar

1. Abrir o projeto em **Eclipse** ou **IntelliJ**
2. Rodar a classe: `Main`
3. Navegar pelo menu interativo no terminal


