# Mini Hospital Emergency Management System

## Introduction

This project is a Mini Hospital Emergency Management System developed using Java.
The system demonstrates the use of different data structures to manage patient
records, emergency patients, treatment history, and patient visit history.

## Objectives

The main objectives of this project are:

- Manage patient records using a Binary Search Tree.
- Manage emergency patients using a Queue.
- Manage treatment history using a Stack.
- Manage previous patient visits using a Singly Linked List.
- Demonstrate important data structure operations using Java.

## Data Structures Used

### 1. Binary Search Tree (BST)

The Binary Search Tree is used to store patient records.

Patient ID is used as the key.

Operations implemented:

- Insert patient
- Search patient
- Delete patient
- In-order traversal

The in-order traversal displays patients in ascending order of Patient ID.

### 2. Queue

A Queue is used to manage emergency patients.

The Queue follows the FIFO principle:

First In, First Out.

Operations implemented:

- Enqueue
- Dequeue
- Display waiting patients
- Empty queue handling

### 3. Stack

A Stack is used to store completed treatment records.

The Stack follows the LIFO principle:

Last In, First Out.

Operations implemented:

- Push treatment
- Pop latest treatment
- Display treatment history
- Empty stack handling

### 4. Singly Linked List

A Singly Linked List is used to maintain patient visit history.

Operations implemented:

- Add visit
- Remove visit
- Search visit
- Display visit history

## Technologies

- Java
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
src/
├── Main.java
├── Patient.java
├── PatientBST.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── TreatmentStack.java
├── Visit.java
└── VisitLinkedList.java