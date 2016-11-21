#include <SoftwareSerial.h>

#define TEMP_SENSOR_PIN A0
#define SERIESRESISTOR 10000

SoftwareSerial mySerial(2, 3); //RX, TX

long pastMillis = millis();
long interval = 1000;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  mySerial.begin(9600);

  Serial.println("Serial and SoftwareSerial test");
  mySerial.println("Serial and SoftwareSerial test");
}


void loop() {
  // put your main code here, to run repeatedly:
  if (millis() - pastMillis > interval) {
    pastMillis += interval;
    String sendStr = "test,";
    sendStr += String(getTemperature(TEMP_SENSOR_PIN));
    sendStr += ",";
    sendStr += String(millis());
    sendStr += "\n";
    Serial.print(sendStr);
    mySerial.print(sendStr);
  }
}

float getTemperature(int pin) { //Measure temperature, origined from Bob-san's program
  int v = 1023 - analogRead(pin);
  float res = (1023.0 / v) - 1;
  res = SERIESRESISTOR / res;
  float temp = (1 / (0.00096564 + (0.00021068 * log(res) ) + (0.000000085826 * ( pow( log(res) , 3))))) - 273.15;
  return temp;
}
