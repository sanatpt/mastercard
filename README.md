# mastercard code challenge: Origin to Destination travel determines if two cities are connected

OriginDestination Travel determines whether two given cities are connected as per below exapmple :

Origin   Destination
Boston   New York
Newark   Boston

# Tools used:

Spring Tool Suite 4 Version: 4.7.1 & GitHub

# Execution Steps

Send HTTP GET requests to localhost port 8080, naming origin and destination cities, thus:

http://localhost:8080/connected?origin=Origin&destination=Destination

If Boston is connected to Newyork by any path along known roads, the response will be:yes

If not, or if the request is not formatted properly, the response will be: no

# Conclusion


