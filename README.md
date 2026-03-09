# Lista Doblemente Enlazada en Java

## Descripción
Este proyecto implementa una estructura de datos de **Lista Doblemente Enlazada** genérica en Java. Una lista doblemente enlazada es una estructura lineal donde cada nodo contiene referencias tanto al nodo siguiente como al anterior, permitiendo recorrer la lista en ambas direcciones. Esta implementación utiliza **generics** para mayor flexibilidad y está optimizada siguiendo los estándares profesionales de Java.

## Características Principales

✅ **Implementación Genérica**: Usa tipos parametrizados `<E>` para trabajar con cualquier tipo de dato  
✅ **Operaciones Completas**: Inserción, eliminación, búsqueda y recorrido  
✅ **Interfaz Interactiva**: Menú amigable con múltiples opciones  
✅ **Manejo de Errores**: Excepciones personalizadas y validación de datos  
✅ **Código Documentado**: Javadoc completo en todas las clases  
✅ **Complejidad Correcta**: Operaciones optimizadas con complejidades O(1) y O(n)

## Clases del Proyecto

### 1. DoublyNode.java
Representa un nodo individual en la lista doblemente enlazada.

**Tipo Genérico:**
- `DoublyNode<E>`: Permite almacenar cualquier tipo de dato

**Atributos:**
- `data: E`: El valor genérico almacenado en el nodo
- `next: DoublyNode<E>`: Referencia al nodo siguiente
- `prev: DoublyNode<E>`: Referencia al nodo anterior

**Métodos:**
- `getData()`: Obtiene el dato del nodo - O(1)
- `setData(E data)`: Establece el dato del nodo - O(1)
- `getNext()`: Obtiene el nodo siguiente - O(1)
- `setNext(DoublyNode<E> next)`: Establece el nodo siguiente - O(1)
- `getPrev()`: Obtiene el nodo anterior - O(1)
- `setPrev(DoublyNode<E> prev)`: Establece el nodo anterior - O(1)
- `toString()`: Representación en string del nodo

### 2. DoublyLinkedList.java
Implementa la estructura completa de la lista doblemente enlazada con todas las operaciones.

**Tipo Genérico:**
- `DoublyLinkedList<E>`: Proporciona flexibilidad de tipos

**Atributos:**
- `head: DoublyNode<E>`: Referencia al primer nodo de la lista
- `tail: DoublyNode<E>`: Referencia al último nodo de la lista
- `size: int`: Número de elementos en la lista

**Métodos de Inserción:**
- `insertAtBeginning(E data)`: Inserta al inicio - O(1)
- `insertAtEnd(E data)`: Inserta al final - O(1)
- `insertAtPosition(E data, int position)`: Inserta en posición específica - O(n)

**Métodos de Recorrido:**
- `traverseForward()`: Recorre de inicio a final - O(n)
- `traverseBackward()`: Recorre de final a inicio - O(n)

**Métodos de Consulta:**
- `getSize()`: Retorna el tamaño de la lista - O(1)
- `isEmpty()`: Verifica si la lista está vacía - O(1)

**Métodos de Búsqueda:**
- `searchByValue(E value)`: Busca un elemento por valor - O(n)
- `searchByIndex(int index)`: Busca un elemento por índice - O(n)

**Métodos de Eliminación:**
- `deleteFromBeginning()`: Elimina del inicio - O(1)
- `deleteFromEnd()`: Elimina del final - O(1)
- `deleteFromPosition(int position)`: Elimina de posición específica - O(n)
- `deleteByValue(E value)`: Elimina un elemento por su valor - O(n)

**Métodos Utilidades:**
- `toArray()`: Convierte la lista a un array - O(n)
- `clear()`: Vacía completamente la lista - O(1)

### 3. Main.java
Programa principal con interfaz de usuario interactiva.

**Menú Principal:**
1. **Insertar al inicio** - Agrega elemento al inicio
2. **Insertar al final** - Agrega elemento al final
3. **Insertar en posición específica** - Agrega elemento en índice dado
4. **Recorrer hacia adelante** - Muestra elementos de inicio a final
5. **Recorrer hacia atrás** - Muestra elementos de final a inicio
6. **Mostrar tamaño** - Muestra cantidad de elementos
7. **Mostrar si está vacía** - Verifica estado de la lista
8. **Buscar por valor** - Busca un elemento específico
9. **Buscar por índice** - Obtiene elemento en posición
10. **Menú de eliminación** - Acceso a opciones de borrado
11. **Mostrar como array** - Visualiza lista en formato array
12. **Limpiar lista** - Vacía todos los elementos
0. **Salir** - Termina el programa

**Submenú de Eliminación:**
1. Eliminar del inicio
2. Eliminar del final
3. Eliminar de posición específica
4. Eliminar por valor

## Compilación y Ejecución

### Requisitos
- Java Development Kit (JDK) 8 o superior instalado

### Opción 1: Terminal 

1. Abre un Nuevo terminal y pega esto 
cd "c:\Users\GUS\Documents\G\Universidad\Ciclo 7\Progra 3\Estructura dinamica"; & "C:\Program Files\Java\jdk-25.0.2\bin\java.exe" Main

Tienes que poner la direccion de donde esta el programa y la java donde esta instalado o ejecutas el .bat
## Ejemplo de uso

```
========================================
  LISTA DOBLEMENTE ENLAZADA - MENÚ PRINCIPAL
========================================
INSERCIÓN:
  1. Insertar al inicio
  2. Insertar al final
  3. Insertar en posición específica
RECORRIDO:
  4. Recorrer hacia adelante
  5. Recorrer hacia atrás
CONSULTAS:
  6. Mostrar tamaño de la lista
  7. Mostrar si la lista está vacía
BÚSQUEDA:
  8. Buscar elemento por valor
  9. Buscar elemento por índice
ELIMINAR:
 10. Menú de eliminación
UTILIDADES:
 11. Mostrar lista como array
 12. Limpiar la lista
  0. Salir
========================================
Selecciona una opción: 2
Ingresa el valor a insertar: 10
✓ Elemento 10 insertado al final.

Selecciona una opción: 2
Ingresa el valor a insertar: 20
✓ Elemento 20 insertado al final.

Selecciona una opción: 2
Ingresa el valor a insertar: 30
✓ Elemento 30 insertado al final.

Selecciona una opción: 4
Recorrido hacia adelante: 10 <-> 20 <-> 30 <-> null

Selecciona una opción: 5
Recorrido hacia atrás: 30 <-> 20 <-> 10 <-> null

Selecciona una opción: 6
Tamaño de la lista: 3 elemento(s)

Selecciona una opción: 11
Lista como array: [10, 20, 30]

Selecciona una opción: 8
Ingresa el valor a buscar: 20
Elemento 20 encontrado en la lista.

Selecciona una opción: 10
--- MENÚ DE ELIMINACIÓN ---
1. Eliminar del inicio
2. Eliminar del final
3. Eliminar de posición específica
4. Eliminar por valor
Selecciona una opción: 4
Ingresa el valor a eliminar: 20
Elemento 20 eliminado.

Selecciona una opción: 4
Recorrido hacia adelante: 10 <-> 30 <-> null

Selecciona una opción: 0
¡Hasta luego!
```

## Complejidad de Operaciones

| Operación | Complejidad Temporal | Justificación |
|-----------|----------------------|---------------|
| Insertar al inicio | O(1) | Acceso directo al head |
| Insertar al final | O(1) | Acceso directo al tail |
| Insertar en posición | O(n) | Requiere buscar la posición |
| Recorrer adelante | O(n) | Visita todos los nodos |
| Recorrer atrás | O(n) | Visita todos los nodos |
| Buscar por valor | O(n) | Worst case: recorrer toda la lista |
| Buscar por índice | O(n) | Worst case: recorrer hasta la posición |
| Eliminar del inicio | O(1) | Acceso directo al head |
| Eliminar del final | O(1) | Acceso directo al tail |
| Eliminar en posición | O(n) | Requiere buscar la posición |
| Eliminar por valor | O(n) | Worst case: recorrer toda la lista |
| getSize() | O(1) | Consulta directa de variable |
| isEmpty() | O(1) | Consulta directa de variable |

## Ventajas y Desventajas

### Ventajas
✅ **Recorrido bidireccional**: Puede recorrerse en ambas direcciones  
✅ **Inserción/eliminación eficiente**: O(1) en extremos si se conoce la posición  
✅ **Flexible**: Implementación genérica para cualquier tipo de dato  
✅ **Dinámico**: No hay límite de tamaño como en arrays  
✅ **Memoria eficiente**: Solo usa la memoria necesaria

### Desventajas
❌ **Acceso aleatorio**: No se puede acceder por índice en O(1) como Arrays  
❌ **Mayor memoria**: Almacena dos referencias por nodo (next y prev)  
❌ **Cache incómodo**: Los nodos pueden estar dispersos en memoria  
❌ **Complejidad**: Más complejo de implementar que arrays simples

## Aplicaciones Prácticas

- **Undo/Redo en editores**: Navegar adelante y atrás en el historial
- **Navegación web**: Botones atrás/adelante del navegador
- **Playlists musicales**: Reproducir canciones adelante o atrás
- **Historial de operaciones**: Deshacer/rehacer operaciones
- **Carruseles interactivos**: Navegación en ambas direcciones
- **Datos con acceso frecuente**: Separar del inicio y final

## Diagrama UML de Clases

```
┌─────────────────────────────────┐
│       DoublyNode<E>             │
├─────────────────────────────────┤
│ - data: E                       │
│ - next: DoublyNode<E>           │
│ - prev: DoublyNode<E>           │
├─────────────────────────────────┤
│ + DoublyNode(E data)            │
│ + getData(): E                  │
│ + setData(E): void              │
│ + getNext(): DoublyNode<E>      │
│ + setNext(DoublyNode<E>): void  │
│ + getPrev(): DoublyNode<E>      │
│ + setPrev(DoublyNode<E>): void  │
│ + toString(): String            │
└─────────────────────────────────┘
          ▲
          │ compone
          │
┌──────────────────────────────────┐
│   DoublyLinkedList<E>            │
├──────────────────────────────────┤
│ - head: DoublyNode<E>            │
│ - tail: DoublyNode<E>            │
│ - size: int                      │
├──────────────────────────────────┤
│ + insertAtBeginning(E): void     │
│ + insertAtEnd(E): void           │
│ + insertAtPosition(E,int): void  │
│ + traverseForward(): void        │
│ + traverseBackward(): void       │
│ + getSize(): int                 │
│ + isEmpty(): boolean             │
│ + searchByValue(E): boolean      │
│ + searchByIndex(int): Node<E>    │
│ + deleteFromBeginning(): void    │
│ + deleteFromEnd(): void          │
│ + deleteFromPosition(int): void  │
│ + deleteByValue(E): boolean      │
│ + toArray(): Object[]            │
│ + clear(): void                  │
└──────────────────────────────────┘
          ▲
          │ utiliza
          │
┌──────────────────────────────────┐
│        Main                      │
├──────────────────────────────────┤
│ - list: DoublyLinkedList<Integ>  │
│ - scanner: Scanner               │
├──────────────────────────────────┤
│ + main(String[]): void           │
│ + displayMenu(): void            │
│ + deleteMenu(): void             │
│ + insertAtBeginning(): void      │
│ + insertAtEnd(): void            │
│ + insertAtPosition(): void       │
│ + searchByValue(): void          │
│ + searchByIndex(): void          │
│ + deleteFromPosition(): void     │
│ + deleteByValue(): void          │
│ + displayArray(): void           │
└──────────────────────────────────┘
```

## Visualización de la Estructura

### Inserción de elementos [1, 2, 3]:

```
Después de insertAtEnd(1):
null <-> [1] <-> null

Después de insertAtEnd(2):
null <-> [1] <-> [2] <-> null

Después de insertAtEnd(3):
null <-> [1] <-> [2] <-> [3] <-> null

Recorrido adelante: 1 <-> 2 <-> 3 <-> null
Recorrido atrás: 3 <-> 2 <-> 1 <-> null
```

## Mejoras Implementadas

Respecto a una implementación básica, este proyecto incluye:

1. **Generics (`<E>`)**: Reutilizable con cualquier tipo de dato
2. **Métodos de eliminación**: Tres formas diferentes de eliminar
3. **insertAtPosition()**: Insertar en posición específica
4. **Mejor manejo de errores**: Excepciones apropiadas con mensajes claros
5. **Menú mejorado**: Interfaz más intuitiva y estructurada
6. **toArray()**: Conversión a formato array
7. **Documentación completa**: Javadoc en todos los métodos
8. **Validaciones**: Verificación de límites y estados

## Autor
**Ciclo 7 - Programación III**  
Estructura Dinámica - 2026

## Licencia
Luis Gustavo Ramirez Berganza 