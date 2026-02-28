// MQ Sensor with Buzzer and LEDs on ESP32

const int MQ_PIN = 34;   // Analog input pin for MQ sensor
const int BUZZER = 21;   // Buzzer pin
const int LED_RED = 23;  // Red LED
const int LED_GREEN = 22; // Green LED

void setup() {
  Serial.begin(115200);
  delay(300);
  
  pinMode(MQ_PIN, INPUT);
  pinMode(BUZZER, OUTPUT);
  pinMode(LED_RED, OUTPUT);
  pinMode(LED_GREEN, OUTPUT);

  digitalWrite(BUZZER, LOW);
  digitalWrite(LED_RED, LOW);
  digitalWrite(LED_GREEN, LOW);

  Serial.println("ESP32 MQ Gas Sensor System Started");
}

void loop() {
  int gasValue = analogRead(MQ_PIN);  // Read analog value from MQ sensor
  Serial.print("Gas Value: ");
  Serial.println(gasValue);

  if (gasValue > 500) {
    // High gas detected
    digitalWrite(BUZZER, HIGH);
    digitalWrite(LED_RED, HIGH);
    digitalWrite(LED_GREEN, LOW);
    Serial.println("⚠ Gas detected! Buzzer and Red LED ON");
  } else {
    // Safe level
    digitalWrite(LED_GREEN, HIGH);
    digitalWrite(BUZZER, LOW);
    digitalWrite(LED_RED, LOW);
    
    Serial.println("✅ Safe level. Green LED ON");
  }

  delay(1000); // Read every second
}