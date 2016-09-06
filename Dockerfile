FROM websphere-liberty

ENV FERRET_VERSION 1.2

RUN wget http://search.maven.org/remotecontent?filepath=net/wasdev/wlp/sample/ferret/$FERRET_VERSION/ferret-$FERRET_VERSION.war -O /config/dropins/ferret.war

