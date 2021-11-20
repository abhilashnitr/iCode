Status: 4.5 YOE
Position: SSE at Product Company
Date: 30 December 2020

The interview process

1. Coding Round ( 2 questions)
https://leetcode.com/problems/reverse-nodes-in-k-group/
Convert number x to y. Only two operations are supported.
Multiply the number the two
Subtract one from the number
I did well in this round. Totally nailed the two questions.

2. Coding Round(1 Question)
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Interviewer changed the question to generate combinations in case below
One number denotes the first character.
Repetition of same number can point to next characters.
e.g 32 will only denote "da". But 322 can denote {"daa", "db"}.
I did well in the first question and coded the second as well. Couldn't figure out the time complexity of second one though. Any help on that is appreciated.

3. LLD Round
Interviewer asked me to design a system which will schedule jobs at a given time. And how to take care of the jobs which are recurring at some frequency. The system has to execute millions of jobs per day. So, you would need more than one server to handle the triggering of job.
Interviewer was more focused on how to actually trigger the job at a given time. The accepted margin of error was 1 second

I didn't do that well in this round.

4. Hiring Manager Round
Standard HR questions. Also asked me to design google drive.


1. First round
First round was written round of duration 60 minutes. There were 6 sections and 30 mcq + 1 coding questions in total. Sections were based on HTML, CSS, Java, Javascript, Data structures and one coding question.

2. Second round
This comprises of three coding questions.
1. https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
2. https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
3. https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/ .
4. One follow up question : for which nxm values, knight can visit each square atleast once.

3. Design round.
This round consisted of two questions.
1. Design nearby/yelp application. DB schema and API design was required. Apart from this, sql query was asked for getting list of places given latitude/longitude. How can you optimize this sql query for densely populated city. Given answers such as partitioning data based on latitude/longitude, indexing etc. Not sure about its answer.
2. Design user feed generation for this nearby application considering reviews as posts. DB schema and API design was required. For faster response, how can you compute user feed. Cache design was discussed. Is this push/pull model for feed generation? Also, how will you cope up with celebrity with many followers.

Phone screen:

given a text and a string, find if all the anagrams (permutation) of string present in text. Followup> how many are presented
Design data structures which support millions of products coming in streaming manner, we need to find at any moment what are top n products at any day
Follow up: now how do you find top n products in every last 1 hour assuming products input stream is every minute.
Onsite:

Round 1:

Design IRCTC search system LDL
Round 2:

https://leetcode.com/problems/middle-of-the-linked-list
Design and implement rate limiter for limiting api calls for a service distributed multiple users.
Round 3:

Twitter design (tweet, retweet, user time line, home time line, hashtag search)
How you balance the tweets from celebrity vs average users for a user home time line?
How do you build user and home time line fast?
Round 4:

Cassandra vs MongoDB
Elastic search vs cached sql table.

Round-1-->F2F
Q1. Implement a function to check whether string s1 is sub-string of String s2 or not?// asking to implement pattern matching algo
Q2. In a machine one DB instance is running which can serve only 50 requests at a time, but in the festival, season request increased from 50 to 100 how will you handle this?//by creating one more instance of DB.
Q3. I have some vendors and all are sending request to my application, I have load balancer & three Working instances (A, B,C) which will handle this request based on the availability( whosoever is free that will handle the request) but if A handle vender v1 request then next time A only has to server v1 request,not others, how will you implement insert,retrieve and search operation?// by hashing technique
Q4. In a party n number of people are present-
There may be a celebrity inside the party which satisfy below criteria

A Person is a celebrity if he/she does not know anyone in the party.
All person must know aa celebrity
implement a function to find out the celebrity?
Round-2-->F2F
Q1. Tell me about your self?
Q2. Implement LRU?
Q3. WAP to check whether the tree is a BST or not?

https://www.geeksforgeeks.org/myntra-interview-set-2-sde-ii/
