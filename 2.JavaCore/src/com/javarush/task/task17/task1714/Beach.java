package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public  class Beach implements Comparable<Beach> {
    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;    //качество

    public  Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result=0;
        if (this.quality> o.quality) result++;
        if (this.quality< o.quality) result--;
        if (this.distance<o.distance) result++;
        if (this.distance>o.distance) result--;
        return result;
    }
}
