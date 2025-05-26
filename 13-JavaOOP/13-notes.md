### 20 – Java Object Oriented Programming

---

[Inheritance]  
→ Use `extends` to reuse methods from parent class  
→ @BeforeMethod runs before every @Test (parent or child)

[TestNG + Inheritance]  
→ Remove boilerplate code  
→ Share common setup logic (e.g., login, setup) across classes

[Single Responsibility Principle]  
→ Test class only triggers logic  
→ Utility class handles actual logic (e.g., PS2, PS3)

---

[OOP Concepts]
1) Parameterized Constructor → pass data to object
2) Instance Variable         → per object (use `this.a`)
3) Class Variable (static)   → shared by all objects
4) Data Independence         → avoid hardcoding; use constructor or data provider

[super]  
→ Call parent constructor → `super(a)`  
→ Must be first line in child constructor

---

[Example Chain]
- PS3 → utility class (multiply)
- PS2 → extends PS3 (add logic, calls `super(a)`)
- PS1 → test class, uses PS2
- PS  → base setup, contains @BeforeMethod
