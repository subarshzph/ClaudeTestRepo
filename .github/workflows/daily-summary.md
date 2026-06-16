---
name: Daily Summary
on:
  schedule:
    - cron: '0 9 * * *' # Runs at 9 AM UTC daily
permissions:
  issues: read
  pull-requests: read
---
# Daily Repo Status Report
Analyze recent issues and pull requests, and provide a concise summary of activity.