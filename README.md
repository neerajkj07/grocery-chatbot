# mindera-grocery-chatbot
A Spring Boot + Spring AI powered chatbot POC for a grocery application.


## ✅ Features (Planned / In Progress)

- ✅ Chat API using Spring Boot
- ✅ OpenAI LLM integration (Spring AI)
- ✅ Product storage in DynamoDB
- ✅ Offer and Discounts in CSV
- ✅ Recipe Suggestions in S3
- ✅ LLM API calls
- ✅ RAG support for knowledge-based answers (vector store)
- ✅ MCP tools to talk to DynamoDB, CSV and S3
- ✅ Docker & Docker Compose setup for local development


---

## ✅ Tech Stack

| Component | Technology |
|----------|------------|
| Backend  | Java + Spring Boot |
| AI       | Spring AI + OpenAI |
| Database | DynamoDB (local or AWS) |
| RAG      | Redis / pgvector / Pinecone (TBD) |
| Build    | Gradle |
| Containerization | Docker & Docker Compose |


## ✅ Run Locally

### 1️⃣ Build
```bash
./gradlew clean build
