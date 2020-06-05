package main.DesignPattern.Strategy;

class StrategyDemo {

  public static void main(String[] args) {

    BaseMap map = new GoogleMapImpl();
    if ("CHINA".equalsIgnoreCase(getCurrentCountry())) {
      map = new BaiduMapImpl();
    }

    initializeMap(map);
  }

  private static String getCurrentCountry () {
    return "CHINA";
  }

  private static void initializeMap(BaseMap map) {
    map.init();
  }
}


abstract class BaseMap {
  abstract void init();

  abstract void drawLines(String[] points);

  abstract void setMarkers(String[] points);

}

class GoogleMapImpl extends BaseMap {
  @Override
  void init() {
    // initialize using google map apis
  }

  @Override
  void drawLines(String[] points) {
    // draw Lines using google map apis
  }

  @Override
  void setMarkers(String[] points) {
    // set Markers Lines using google map apis
  }
}

class BaiduMapImpl extends BaseMap {
  @Override
  void init() {
    // initialize using Baidu map apis
  }

  @Override
  void drawLines(String[] points) {
    // draw Lines using Baidu map apis
  }

  @Override
  void setMarkers(String[] points) {
    // set Markers Lines using Baidu map apis
  }
}

