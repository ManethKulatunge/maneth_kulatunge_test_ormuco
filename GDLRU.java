package maneth_kulatunge_testOrmuco;

import java.util.Hashtable;


public class GDLRU {

//defining a entry to the GDLRU
class CacheEntry {
  int key;
  int value;
  CacheEntry previous;
  CacheEntry next;
}

//Add the new entry right after the start of the cache;

private void addEntry(CacheEntry entry) {
    
  entry.previous = start;
  entry.next = start.next;

  start.next.previous = entry;
  start.next = entry;
}

//Remove an existing entry from the cache
 
private void removeEntry(CacheEntry entry){
  CacheEntry previous = entry.previous;
  CacheEntry next = entry.next;

  previous.next = next;
  next.previous = previous;
}

//Move certain entry (generally in getCacheEntry) in between to the start.
private void moveTostart(CacheEntry entry){
  this.removeEntry(entry);
  this.addEntry(entry);
}

// pop the current end. 
private CacheEntry popEnd(){
  CacheEntry tail = end.previous;
  this.removeEntry(tail);
  return tail;
}

private Hashtable<Integer, CacheEntry> 
cache = new Hashtable<Integer, CacheEntry>();
private int count;
private int size;
private CacheEntry start, end;

//constructor for the Geo Distributed Least Recently Used Cache
public GDLRU(int size) {
  this.count = 0;
  this.size = size;

  start = new CacheEntry();
  start.previous = null;

  end = new CacheEntry();
  end.next = null;

  start.next = end;
  end.previous = start;
}

//getting a certain Cache Entry 
public int getCacheEntry(int key) {

  CacheEntry entry = cache.get(key);
  if(entry == null){
    return -1; // should raise exception here.
  }

  // move the accessed entry to the start to update Cache;
  this.moveTostart(entry);

  return entry.value;
}

//Method to add a new entry to the GDLRU Cache
public void addEntry(int key, int value) {
  CacheEntry entry = cache.get(key);

  if(entry == null){

    CacheEntry newentry = new CacheEntry();
    newentry.key = key;
    newentry.value = value;

    this.cache.put(key, newentry);
    //Overloaded addEntry method
    this.addEntry(newentry);

    ++count;

    if(count > size){
      // pop the end of the Cache if its capacity is full
      CacheEntry end = this.popEnd();
      this.cache.remove(end.key);
      --count;
    }
  }else{
    // update the value of the existing key
    entry.value = value;
    this.moveTostart(entry);
  }
}

}