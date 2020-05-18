package DesignPattern.Observer;

public class ObserverPatternDemo {

    public static void main(String args[])
    {
        // create objects for testing
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();

        // pass the displays to Cricket data
        CricketData cricketData = new CricketData();

        // register display elements
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        // in real app you would have some logic to
        // call this function when data changes
        cricketData.dataChanged();

        //remove an observer
        cricketData.unregisterObserver(averageScoreDisplay);

        // now only currentScoreDisplay gets the
        // notification
        cricketData.dataChanged();
    }
}


/*
Benefits:
It describes the coupling between the objects and the observer.
It provides the support for broadcast-type communication.
Usage:
When the change of a state in one object must be reflected in another object without keeping the objects tight coupled.
When the framework we writes and needs to be enhanced in future with new observers with minimal chamges.
*/