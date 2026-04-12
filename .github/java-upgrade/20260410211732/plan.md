# Upgrade Plan: game-library (20260410211732)

- **Generated**: 2026-04-10 21:17:32 UTC
- **HEAD Branch**: dev
- **HEAD Commit ID**: N/A (will capture after stash is applied)

## Available Tools

| Tool                    | Current Version | Required For              | Action        | Location (if installed)    |
| ----------------------- | --------------- | ------------------------- | ------------- | -------------------------- |
| Java Development Kit    | **21**          | Baseline & Testing        | Install 21    | C:\Program Files\Java\jdk-21 |
| Java Development Kit    | **24** (found)  | N/A (upgrade to 25)       | N/A           | C:\Program Files\Java\jdk-24  |
| Java Development Kit    | **25**          | Java 25 Compilation       | <TO_BE_INSTALLED> | C:\Program Files\Java\jdk-25  |
| Maven (Wrapper)         | **3.9.14**      | Build Tool                | No change     | .mvn/wrapper/maven-wrapper.properties |

## Guidelines

- Direct upgrade path: Java 21 → 25 (no intermediate version needed per compatibility analysis)
- Spring Boot 4.0.5 fully supports Java 25
- Maven 3.9.14 supports Java 25 (no build tool upgrade required)
- All tests should pass with Java 25 (no code changes expected)

## Options

- Working branch: appmod/java-upgrade-20260410211732
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java from 21 (LTS) to 25 (latest LTS)

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- |
| Java (Runtime)        | 21 (LTS) | 25 (LTS)      | User requested target version |
| Spring Boot           | 4.0.5   | 4.0.5          | Fully compatible with Java 25 |
| Spring Data JPA       | 3.x (via SB) | 3.x (via SB) | No change needed |
| Thymeleaf             | 3.x (via SB) | 3.x (via SB) | No change needed |
| H2 Database           | 2.x (via SB) | 2.x (via SB) | No change needed |
| Lombok                | 1.x (via SB) | 1.x (via SB) | No change needed |
| Maven (wrapper)       | 3.9.14  | 3.9.14         | Supports Java 25 |

## Derived Upgrades

No mandatory dependency upgrades. All current dependencies are compatible with Java 25 via Spring Boot 4.0.5 compatibility guarantees.

## Upgrade Steps

### Step 1: Setup Environment

**Objective:** Install required JDK versions

**Rationale:** Establish Java 21 for baseline testing and Java 25 for target compilation. This allows parallel verification of upgrade compatibility.

**Changes to Make:**
- Install JDK 21 (required for step 2 baseline)
- Install JDK 25 (required for step 3-4 upgrade)
- Verify both installations via `java -version`

**Verification:**
- Command: `#appmod-install-jdk version=21` and `#appmod-install-jdk version=25`
- Expected: Both JDKs available and environment properly configured

---

### Step 2: Setup Baseline

**Objective:** Establish baseline compile and test results with Java 21

**Rationale:** Document pre-upgrade state to verify upgrade success. This creates acceptance criteria for later validation steps.

**Changes to Make:**
- Set JAVA_HOME to Java 21
- Run `mvn clean test-compile`
- Run `mvn clean test`
- Document compilation and test results

**Verification:**
- Command: `mvn clean test-compile` then `mvn clean test`
- JDK: Java 21
- Expected: Compilation SUCCESS + All tests pass (or document pre-existing failures)

---

### Step 3: Upgrade Java Version

**Objective:** Update project configuration to target Java 25

**Rationale:** Update the build configuration to compile and run against Java 25. This is the minimal change needed to upgrade the runtime target.

**Changes to Make:**
- Update `pom.xml` `<java.version>` from 21 to 25
- Set JAVA_HOME to Java 25
- Run `mvn clean test-compile` to verify compilation

**Verification:**
- Command: `mvn clean test-compile`
- JDK: Java 25
- Expected: Compilation SUCCESS (both main and test source code)

---

### Step 4: Final Validation

**Objective:** Verify all tests pass on Java 25 and confirm upgrade success

**Rationale:** Ensure 100% test pass rate with Java 25 to confirm all functionality works correctly on the upgraded runtime. This is the final acceptance gate.

**Changes to Make:**
- Verify Java 25 is target in `pom.xml`
- Run `mvn clean test` with Java 25
- Fix any test failures (iterative loop)
- Document upgrade completion

**Verification:**
- Command: `mvn clean test`
- JDK: Java 25
- Expected: Compilation SUCCESS + 100% tests pass (same as or better than baseline from Step 2)

---

## Key Challenges

**Java 21 → 25 Direct Upgrade**
- Challenge: Both Java 21 and 25 are LTS with stable APIs, minimal compatibility issues expected
- Strategy: Direct upgrade without intermediate version. No code changes anticipated.

**Test Coverage Validation**
- Challenge: Ensure all tests pass identically on Java 25 as they did on Java 21
- Strategy: Run tests in Step 2 (baseline) and Step 4 (validation), compare results

---

## Plan Review

- ✅ All required JDKs identified and marked for installation
- ✅ Direct upgrade path confirmed (Java 21 → 25 compatible)
- ✅ Maven 3.9.14 supports Java 25 (no upgrade needed)
- ✅ Spring Boot 4.0.5 supports Java 25 natively
- ✅ No intermediate versions required
- ✅ All 4 mandatory steps present
- ✅ No unfixable limitations identified

---

## Sign-off

- **Plan Generated:** 2026-04-10 21:17:32 UTC
- **Status:** ✅ Ready for user confirmation and execution
