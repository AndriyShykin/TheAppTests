#!/bin/bash
mvn test -Dsurefire.rerunFailingTestsCount=1 -Dtest="**/ui/**/*.java"
