# E-Commerce Search System

This program represents a simple product search system for an e-commerce platform. It demonstrates two search strategies:

- **Linear Search** – Scans every product in the list to find a match.
- **Binary Search** – Operates on a sorted array and uses divide-and-conquer for faster searching.

---

## Core Features

- Defines a `Product` class with `productId`, `productName`, and `category`.
- Implements `Comparable<Product>` to allow natural sorting by `productName`.
- Performs **case-insensitive comparisons** using `.toLowerCase()`.
- Supports both linear and binary search.
- Outputs matched search results and algorithm analysis.

---

## Time Complexity Analysis

| Operation       | Data Structure        | Time Complexity     | Explanation |
|----------------|-----------------------|---------------------|-------------|
| **Add**        | Array (`Product[]`)   | `O(1)` (if at end) / `O(n)` (if resized) | Adding to end is fast; resizing is expensive |
| **Update**     | Array                 | `O(1)` by index / `O(n)` by value | Direct index is fast, search is slow |
| **Delete**     | Array                 | `O(n)`              | Elements need to be shifted |
| **Linear Search** | Array              | `O(n)`              | Scans all items |
| **Binary Search** | Sorted Array       | `O(log n)`          | Requires sorted data |
| **Sorting**    | Array (`Arrays.sort`) | `O(n log n)`        | Uses dual-pivot quicksort or TimSort |

---

## Optimization Strategies

### 1. Use Better Data Structures
- Use `ArrayList<Product>` for dynamic sizing.
- Use `HashMap<String, Product>` for `O(1)` search/update/delete by key.

### 2. Reduce Case Conversion Overhead
- Store `productName` in lowercase during creation to avoid repeated `.toLowerCase()` calls.

### 3. Sort Once and Cache
- Perform sorting once and reuse the sorted array for binary searches.

### 4. Use Binary Search for Large Datasets
- Binary search is ideal for large, sorted datasets due to logarithmic performance.

---


