# Getting Started

### Step-by-step instruction:

For further reference, please consider the following sections:

1. Clone repository - `git clone https://github.com/DancerInTheDark/CurrencyExchangeGA.git`
2. Run `./gradlew clean build`
3. Update docker-compose.yml file with own GA property id and custom metric name (metric should be configured as Currency type)
   1. GA_PROPERTY_ID
   2. GA_RATE_METRIC
4. Run `docker-compose build`
5. Run `docker-compose up`
6. Check sent events in GA property
