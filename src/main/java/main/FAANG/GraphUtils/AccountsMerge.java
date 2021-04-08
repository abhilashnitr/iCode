package main.FAANG.GraphUtils;

import java.util.*;

public class AccountsMerge {
    /*
The key task here is to connect those emails, and this is a perfect use case for union find.
to group these emails, each group need to have a representative, or parent.
At the beginning, set each email as its own representative.
Emails in each account naturally belong to a same group, and should be joined by assigning to the same parent (let's use the parent of first email in that list);
Simple Example:
a b c // now b, c have parent a
d e f // now e, f have parent d
g a d // now abc, def all merged to group g
parents populated after parsing 1st account: a b c
a->a
b->a
c->a
parents populated after parsing 2nd account: d e f
d->d
e->d
f->d
parents populated after parsing 3rd account: g a d
g->g
a->g
d->g
*/

    public static void main(String[] args) {
        List<List<String>> lists=Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),Arrays.asList("John", "johnnybravo@mail.com"),Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),Arrays.asList("Mary", "mary@mail.com"));
        AccountsMerge accountsMerge=new AccountsMerge();
        System.out.println(accountsMerge.accountsMerge(lists));
    }
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}
