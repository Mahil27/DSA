# 📌 Sliding Window Patterns — Complete DSA Guide

This document explains all Sliding Window patterns used in Data Structures and Algorithms with clear conditions, templates, and identification rules.

---

## 🔹 What is Sliding Window?

Sliding Window is an optimization technique to solve problems involving **contiguous subarrays or substrings** in **O(n)** time instead of O(n²).

---

## 🔹 When to Use Sliding Window

Use sliding window when:

- The problem involves contiguous subarray or substring  
- You need maximum, minimum, count, or length  
- Brute force approach is too slow  

---

## 🔹 Types of Sliding Window

| Type | When |
|------|------|
| Fixed Size Window | Window size is given |
| Variable Size Window | Window depends on condition |

---

# 🟢 Fixed Size Sliding Window

### Identification
Window size `k` is given.

### Condition Break

```
right - left + 1 > k
```

### Template

```java
int l=0, sum=0;
for(int r=0;r<n;r++){
    sum+=arr[r];

    if(r-l+1==k){
        // process window
        sum-=arr[l];
        l++;
    }
}
```

### Used For

- Max sum subarray of size k  
- Min sum subarray of size k  
- Average of subarray  

---

# 🟡 Variable Size Sliding Window

Used when window size depends on condition.

### Template

```java
int l=0;
for(int r=0;r<n;r++){
    add element

    while(condition breaks){
        remove element
        l++;
    }

    update answer
}
```

---

# 🔵 Pattern 1: Longest Window Problems

Used for **maximum length**.

### Condition Break Rules

| Problem | Break Condition |
|-------|---------------|
| Longest substring without repeating | freq(char) > 1 |
| Longest substring with k distinct | map.size() > k |
| Longest subarray sum ≤ k | sum > k |
| Longest ones after k replacement | zeroCount > k |

### Rule

Shrink when condition breaks, update answer after shrinking.

---

# 🟠 Pattern 2: Smallest Window Problems

Used for **minimum length**.

### Condition Break Rules

| Problem | Break Condition |
|-------|---------------|
| Smallest subarray sum ≥ k | sum >= k |
| Minimum window substring | window contains all required chars |

### Rule

Shrink while condition is satisfied, update answer before shrinking.

---

# 🟣 Pattern 3: Count Window Problems

Used for counting subarrays.

### Condition Break Rules

| Problem | Break Condition |
|-------|---------------|
| Subarrays with at most k distinct | map.size() > k |
| Subarrays with sum ≤ k | sum > k |

### Rule

```
count += right - left + 1
```

---

# 🔴 Pattern 4: Exactly K Distinct

Direct logic is never written.

### Formula

```
exact(K) = atMost(K) - atMost(K-1)
```

### Break Condition inside atMost

```
map.size() > k
```

Used for:

- Subarrays with exactly k distinct  
- Substrings with exactly k unique characters  

---

# 🟤 Pattern 5: Binary Sliding Window

Used for binary arrays.

### Condition Break

```
zeroCount > k
```

Used for:

- Maximum consecutive ones  
- Replace k zeros  

---

# 🔹 Data Structure Selection

| Requirement | Use |
|-----------|-----|
| Presence only | HashSet |
| Frequency tracking | HashMap |
| Lowercase characters | int[26] |

---

# 🔹 Interview Identification Guide

| Question Says | Pattern |
|--------------|--------|
| size = k | Fixed window |
| longest / maximum | Longest window |
| smallest / minimum | Smallest window |
| count | Count window |
| exactly k | Difference method |

---

# 🔹 Master Shrinking Rule

| Want | Shrink When |
|-----|-----------|
| Longest | Condition breaks |
| Smallest | Condition satisfied |
| Count | Condition breaks |
| Fixed | Window exceeds size |

---

# 🔹 Time Complexity

All sliding window solutions run in:

```
O(n)
```

---

# 🔹 Common Mistakes

- Using Set when frequency is needed  
- Forgetting to remove zero from map  
- Shrinking window at wrong time  
- Writing direct exactly-k logic  

---

# 🔹 Author

Mahil Dev  
DSA Repository  
