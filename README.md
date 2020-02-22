# Test_Ormuco
**Question A:**
Test Cases:
  
  1.  Input: [ {1,3} , {2,4} ] 
      Output : Overlap 
  
  2. Input: [ {1,5} , {1,4} ] 
     Output: Overlap 
     
  3. Input: [ {1,5} , {5,6} ] 
     Output: No overlap 
     Explanation: based on assumption that last point being equal means no overlap
     
  4. Input: [ {1,2} , {3,4} ] 
     Output: No overlap
     
  5. Input: [ {1,1} , {1,1} ] 
     Output:Overlap 
     Explanation: It is a single point

**Question B**
Test Cases: 

  1.  Input: version1 = "0.1", version2 = "1.1"
      Output: "0.1 is less than 1.1"

  2.  Input: version1 = "1.0.1", version2 = "1"
      Output: "1.0 and 1.0.1 are equal"

  3.  Input: version1 = "7.2.2.2.4", version2 = "7.2.3"
      Output: "7.2.2.2.4 is less than 7.2.3"

**Question C** (named as GDLRU)

  -The Cache is implemented with a Hashtable and a Doubly linkedlist to reduce timecomplexity taken up when     
   lookup occurs and the Doubly linked list allows easy travelling between the entries of the cache.
   
   Possible Improvements:
    -Cache Expiry feature
