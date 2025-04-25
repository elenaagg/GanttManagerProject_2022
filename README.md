# GanttManagerProject_2022

A Java-based application for managing Gantt charts, developed as part of the Software Engineering course at the University of Ioannina during the academic year 2022–2023.

## 📌 Project Description

This software system allows users (project managers) to create, load, manage, and export project plans using Gantt diagrams. It supports both simple and composite tasks, automatic computation of task durations and costs, as well as multiple data export formats (text, Markdown, HTML).

## 💡 Features

- Load tasks from a plain delimited text file
- Display all tasks sorted by start date and task ID
- Display only top-level tasks
- Search tasks by:
  - Task ID
  - Description prefix
- Export reports in:
  - Plain text
  - Markdown
  - HTML
- Console-based UI and (optionally) GUI
- Modular design following a two-layer architecture (frontend/backend)
- Unit testing with JUnit 4

## 🛠 Technologies Used

- Java 8
- Eclipse IDE
- JUnit 4
- Apache Commons Collections (PatriciaTrie)
