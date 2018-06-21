package exam2;

import java.io.*;
import java.util.*;

public class PerformanceTest {
    private static Map<String, Map> dependenciesBySubject = new HashMap<>();
    private static List<String> result = new ArrayList<>();
    private static long inputTime = 0;
    private static long outputTime = 0;
    private static long readIn = 0;
    private static long putTime = 0;
    private static long inMethodTime = 0;

    public static void main(String[] args) {
        fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();
        // Read data

        long startIn = System.currentTimeMillis();
        int n = in.readInt();
        for (int i = 0; i < n; i++) {

            String line = in.readLine();
            int space1Idx = line.indexOf(' ');
            int space2Idx = line.indexOf(' ', space1Idx + 1);
            String personX = line.substring(0, space1Idx);
            String personY = line.substring(space1Idx + 1, space2Idx);
            String subject = line.substring(space2Idx + 1);

            if (!dependenciesBySubject.containsKey(subject)) {
                Map<String, Set> dependBySubject = new HashMap<>();
                dependenciesBySubject.put(subject, dependBySubject);
            }

            Map<String, Set> personDependencyBySubject = dependenciesBySubject.get(subject);

            if (!personDependencyBySubject.containsKey(personX)) {
                Set<String> prerequisitePeople = new TreeSet<>();
                personDependencyBySubject.put(personX, prerequisitePeople);
            }

            personDependencyBySubject.get(personX).add(personY);
        }
        long endIn = System.currentTimeMillis();
        inputTime += endIn - startIn;


        // Read commands
//        long startOut = System.currentTimeMillis();
//        int m = in.readInt();
//
//        for (int i = 0; i < m; i++) {
//            result.clear();
//            String command = in.readLine();
//            int space1Idx = command.indexOf(' ');
//            String personX = command.substring(0, space1Idx);
//            String subject = command.substring(space1Idx + 1);
//
//            Map<String, Set> dependencyMapForSubject = dependenciesBySubject.get(subject);
//
//            findDependencies(personX, dependencyMapForSubject, new HashSet<>());
//            result.add(personX);
//
//            StringBuilder res = new StringBuilder();
//
//            for (int j = 0; j < result.size(); j++) {
//                res.append(result.get(j));
//
//                if (j == result.size() - 1) {
//                    continue;
//                }
//                res.append(", ");
//            }
//            out.printLine(res);
//        }
//
//        long endOut = System.currentTimeMillis();
//        outputTime += endOut - startOut;

        System.out.printf("Input: %d\n", inputTime);
        System.out.printf("Output: %d\n", outputTime);
        out.close();
    }

    private static void findDependencies(String personX,
                                         Map<String, Set> dependencyMapForSubject,
                                         Set<String> visited) {
        Set<String> prerequisites = dependencyMapForSubject.get(personX);
        visited.add(personX);
        if (prerequisites == null) {
            return;
        }
        for (String prerequisite : prerequisites) {
            if (!visited.contains(prerequisite)) {
                findDependencies(prerequisite, dependencyMapForSubject, visited);
                visited.add(prerequisite);
                result.add(prerequisite);
            }
        }

    }


    private static void fakeInput() {
        String test = "1769\n" +
                "d1 d2 s1\n" +
                "d1 d2 s2\n" +
                "d1 d2 s3\n" +
                "d1 d2 s4\n" +
                "d1 d2 s5\n" +
                "d1 d2 s6\n" +
                "d1 d2 s7\n" +
                "d1 d2 s8\n" +
                "d1 d2 s9\n" +
                "d1 d2 s10\n" +
                "d1 d2 s11\n" +
                "d1 d2 s12\n" +
                "d1 d2 s13\n" +
                "d1 d2 s14\n" +
                "d1 d2 s15\n" +
                "d1 d2 s16\n" +
                "d1 d2 s17\n" +
                "d1 d2 s18\n" +
                "d1 d2 s19\n" +
                "d1 d2 s20\n" +
                "d1 d2 s21\n" +
                "d1 d2 s22\n" +
                "d1 d2 s23\n" +
                "d1 d2 s24\n" +
                "d1 d2 s25\n" +
                "d1 d2 s26\n" +
                "d1 d2 s27\n" +
                "d1 d2 s28\n" +
                "d1 d2 s29\n" +
                "d1 d2 s30\n" +
                "d1 d2 s31\n" +
                "d1 d2 s32\n" +
                "d1 d2 s33\n" +
                "d1 d2 s34\n" +
                "d1 d2 s35\n" +
                "d1 d2 s36\n" +
                "d1 d2 s37\n" +
                "d1 d2 s38\n" +
                "d1 d2 s39\n" +
                "d1 d2 s40\n" +
                "d1 d2 s41\n" +
                "d1 d2 s42\n" +
                "d1 d2 s43\n" +
                "d1 d2 s44\n" +
                "d1 d2 s45\n" +
                "d1 d2 s46\n" +
                "d1 d2 s47\n" +
                "d1 d2 s48\n" +
                "d1 d2 s49\n" +
                "d1 d2 s50\n" +
                "d1 d2 s51\n" +
                "d1 d2 s52\n" +
                "d1 d2 s53\n" +
                "d1 d2 s54\n" +
                "d1 d2 s55\n" +
                "d1 d2 s56\n" +
                "d1 d2 s57\n" +
                "d1 d2 s58\n" +
                "d1 d2 s59\n" +
                "d1 d2 s60\n" +
                "d1 d2 s61\n" +
                "d1 d2 s62\n" +
                "d1 d2 s63\n" +
                "d1 d2 s64\n" +
                "d1 d2 s65\n" +
                "d1 d2 s66\n" +
                "d1 d2 s67\n" +
                "d1 d2 s68\n" +
                "d1 d2 s69\n" +
                "d1 d2 s70\n" +
                "d1 d2 s71\n" +
                "d1 d2 s72\n" +
                "d1 d2 s73\n" +
                "d1 d2 s74\n" +
                "d1 d2 s75\n" +
                "d1 d2 s76\n" +
                "d1 d2 s77\n" +
                "d1 d2 s78\n" +
                "d1 d2 s79\n" +
                "d1 d2 s80\n" +
                "d1 d2 s81\n" +
                "d1 d2 s82\n" +
                "d1 d2 s83\n" +
                "d1 d2 s84\n" +
                "d1 d2 s85\n" +
                "d1 d2 s86\n" +
                "d1 d2 s87\n" +
                "d1 d2 s88\n" +
                "d1 d2 s89\n" +
                "d1 d2 s90\n" +
                "d1 d2 s91\n" +
                "d1 d2 s92\n" +
                "d1 d2 s93\n" +
                "d1 d2 s94\n" +
                "d1 d2 s95\n" +
                "d1 d2 s96\n" +
                "d1 d2 s97\n" +
                "d1 d2 s98\n" +
                "d1 d2 s99\n" +
                "d1 d2 s100\n" +
                "d1 d2 s101\n" +
                "d1 d2 s102\n" +
                "d1 d2 s103\n" +
                "d1 d2 s104\n" +
                "d1 d2 s105\n" +
                "d1 d2 s106\n" +
                "d1 d2 s107\n" +
                "d1 d2 s108\n" +
                "d1 d2 s109\n" +
                "d1 d2 s110\n" +
                "d1 d2 s111\n" +
                "d1 d2 s112\n" +
                "d1 d2 s113\n" +
                "d1 d2 s114\n" +
                "d1 d2 s115\n" +
                "d1 d2 s116\n" +
                "d1 d2 s117\n" +
                "d1 d2 s118\n" +
                "d1 d2 s119\n" +
                "d1 d2 s120\n" +
                "d1 d2 s121\n" +
                "d1 d2 s122\n" +
                "d1 d2 s123\n" +
                "d1 d2 s124\n" +
                "d1 d2 s125\n" +
                "d1 d2 s126\n" +
                "d1 d2 s127\n" +
                "d1 d2 s128\n" +
                "d1 d2 s129\n" +
                "d1 d2 s130\n" +
                "d1 d2 s131\n" +
                "d1 d2 s132\n" +
                "d1 d2 s133\n" +
                "d1 d2 s134\n" +
                "d1 d2 s135\n" +
                "d1 d2 s136\n" +
                "d1 d2 s137\n" +
                "d1 d2 s138\n" +
                "d1 d2 s139\n" +
                "d1 d2 s140\n" +
                "d1 d2 s141\n" +
                "d1 d2 s142\n" +
                "d1 d2 s143\n" +
                "d1 d2 s144\n" +
                "d1 d2 s145\n" +
                "d1 d2 s146\n" +
                "d1 d2 s147\n" +
                "d1 d2 s148\n" +
                "d1 d2 s149\n" +
                "d1 d2 s150\n" +
                "d1 d2 s151\n" +
                "d1 d2 s152\n" +
                "d1 d2 s153\n" +
                "d1 d2 s154\n" +
                "d1 d2 s155\n" +
                "d1 d2 s156\n" +
                "d1 d2 s157\n" +
                "d1 d2 s158\n" +
                "d1 d2 s159\n" +
                "d1 d2 s160\n" +
                "d1 d2 s161\n" +
                "d1 d2 s162\n" +
                "d1 d2 s163\n" +
                "d1 d2 s164\n" +
                "d1 d2 s165\n" +
                "d1 d2 s166\n" +
                "d1 d2 s167\n" +
                "d1 d2 s168\n" +
                "d1 d2 s169\n" +
                "d1 d2 s170\n" +
                "d1 d2 s171\n" +
                "d1 d2 s172\n" +
                "d1 d2 s173\n" +
                "d1 d2 s174\n" +
                "d1 d2 s175\n" +
                "d1 d2 s176\n" +
                "d1 d2 s177\n" +
                "d1 d2 s178\n" +
                "d1 d2 s179\n" +
                "d1 d2 s180\n" +
                "d1 d2 s181\n" +
                "d1 d2 s182\n" +
                "d1 d2 s183\n" +
                "d1 d2 s184\n" +
                "d1 d2 s185\n" +
                "d1 d2 s186\n" +
                "d1 d2 s187\n" +
                "d1 d2 s188\n" +
                "d1 d2 s189\n" +
                "d1 d2 s190\n" +
                "d1 d2 s191\n" +
                "d1 d2 s192\n" +
                "d1 d2 s193\n" +
                "d1 d2 s194\n" +
                "d1 d2 s195\n" +
                "d1 d2 s196\n" +
                "d1 d2 s197\n" +
                "d1 d2 s198\n" +
                "d1 d2 s199\n" +
                "d1 d2 s200\n" +
                "d1 d2 s201\n" +
                "d1 d2 s202\n" +
                "d1 d2 s203\n" +
                "d1 d2 s204\n" +
                "d1 d2 s205\n" +
                "d1 d2 s206\n" +
                "d1 d2 s207\n" +
                "d1 d2 s208\n" +
                "d1 d2 s209\n" +
                "d1 d2 s210\n" +
                "d1 d2 s211\n" +
                "d1 d2 s212\n" +
                "d1 d2 s213\n" +
                "d1 d2 s214\n" +
                "d1 d2 s215\n" +
                "d1 d2 s216\n" +
                "d1 d2 s217\n" +
                "d1 d2 s218\n" +
                "d1 d2 s219\n" +
                "d1 d2 s220\n" +
                "d1 d2 s221\n" +
                "d1 d2 s222\n" +
                "d1 d2 s223\n" +
                "d1 d2 s224\n" +
                "d1 d2 s225\n" +
                "d1 d2 s226\n" +
                "d1 d2 s227\n" +
                "d1 d2 s228\n" +
                "d1 d2 s229\n" +
                "d1 d2 s230\n" +
                "d1 d2 s231\n" +
                "d1 d2 s232\n" +
                "d1 d2 s233\n" +
                "d1 d2 s234\n" +
                "d1 d2 s235\n" +
                "d1 d2 s236\n" +
                "d1 d2 s237\n" +
                "d1 d2 s238\n" +
                "d1 d2 s239\n" +
                "d1 d2 s240\n" +
                "d1 d2 s241\n" +
                "d1 d2 s242\n" +
                "d1 d2 s243\n" +
                "d1 d2 s244\n" +
                "d1 d2 s245\n" +
                "d1 d2 s246\n" +
                "d1 d2 s247\n" +
                "d1 d2 s248\n" +
                "d1 d2 s249\n" +
                "d1 d2 s250\n" +
                "d1 d2 s251\n" +
                "d1 d2 s252\n" +
                "d1 d2 s253\n" +
                "d1 d2 s254\n" +
                "d1 d2 s255\n" +
                "d1 d2 s256\n" +
                "d1 d2 s257\n" +
                "d1 d2 s258\n" +
                "d1 d2 s259\n" +
                "d1 d2 s260\n" +
                "d1 d2 s261\n" +
                "d1 d2 s262\n" +
                "d1 d2 s263\n" +
                "d1 d2 s264\n" +
                "d1 d2 s265\n" +
                "d1 d2 s266\n" +
                "d1 d2 s267\n" +
                "d1 d2 s268\n" +
                "d1 d2 s269\n" +
                "d1 d2 s270\n" +
                "d1 d2 s271\n" +
                "d1 d2 s272\n" +
                "d1 d2 s273\n" +
                "d1 d2 s274\n" +
                "d1 d2 s275\n" +
                "d1 d2 s276\n" +
                "d1 d2 s277\n" +
                "d1 d2 s278\n" +
                "d1 d2 s279\n" +
                "d1 d2 s280\n" +
                "d1 d2 s281\n" +
                "d1 d2 s282\n" +
                "d1 d2 s283\n" +
                "d1 d2 s284\n" +
                "d1 d2 s285\n" +
                "d1 d2 s286\n" +
                "d1 d2 s287\n" +
                "d1 d2 s288\n" +
                "d1 d2 s289\n" +
                "d1 d2 s290\n" +
                "d1 d2 s291\n" +
                "d1 d2 s292\n" +
                "d1 d2 s293\n" +
                "d1 d2 s294\n" +
                "d1 d2 s295\n" +
                "d1 d2 s296\n" +
                "d1 d2 s297\n" +
                "d1 d2 s298\n" +
                "d1 d2 s299\n" +
                "d1 d2 s300\n" +
                "d1 d2 s301\n" +
                "d1 d2 s302\n" +
                "d1 d2 s303\n" +
                "d1 d2 s304\n" +
                "d1 d2 s305\n" +
                "d1 d2 s306\n" +
                "d1 d2 s307\n" +
                "d1 d2 s308\n" +
                "d1 d2 s309\n" +
                "d1 d2 s310\n" +
                "d1 d2 s311\n" +
                "d1 d2 s312\n" +
                "d1 d2 s313\n" +
                "d1 d2 s314\n" +
                "d1 d2 s315\n" +
                "d1 d2 s316\n" +
                "d1 d2 s317\n" +
                "d1 d2 s318\n" +
                "d1 d2 s319\n" +
                "d1 d2 s320\n" +
                "d1 d2 s321\n" +
                "d1 d2 s322\n" +
                "d1 d2 s323\n" +
                "d1 d2 s324\n" +
                "d1 d2 s325\n" +
                "d1 d2 s326\n" +
                "d1 d2 s327\n" +
                "d1 d2 s328\n" +
                "d1 d2 s329\n" +
                "d1 d2 s330\n" +
                "d1 d2 s331\n" +
                "d1 d2 s332\n" +
                "d1 d2 s333\n" +
                "d1 d2 s334\n" +
                "d1 d2 s335\n" +
                "d1 d2 s336\n" +
                "d1 d2 s337\n" +
                "d1 d2 s338\n" +
                "d1 d2 s339\n" +
                "d1 d2 s340\n" +
                "d1 d2 s341\n" +
                "d1 d2 s342\n" +
                "d1 d2 s343\n" +
                "d1 d2 s344\n" +
                "d1 d2 s345\n" +
                "d1 d2 s346\n" +
                "d1 d2 s347\n" +
                "d1 d2 s348\n" +
                "d1 d2 s349\n" +
                "d1 d2 s350\n" +
                "d1 d2 s351\n" +
                "d1 d2 s352\n" +
                "d1 d2 s353\n" +
                "d1 d2 s354\n" +
                "d1 d2 s355\n" +
                "d1 d2 s356\n" +
                "d1 d2 s357\n" +
                "d1 d2 s358\n" +
                "d1 d2 s359\n" +
                "d1 d2 s360\n" +
                "d1 d2 s361\n" +
                "d1 d2 s362\n" +
                "d1 d2 s363\n" +
                "d1 d2 s364\n" +
                "d1 d2 s365\n" +
                "d1 d2 s366\n" +
                "d1 d2 s367\n" +
                "d1 d2 s368\n" +
                "d1 d2 s369\n" +
                "d1 d2 s370\n" +
                "d1 d2 s371\n" +
                "d1 d2 s372\n" +
                "d1 d2 s373\n" +
                "d1 d2 s374\n" +
                "d1 d2 s375\n" +
                "d1 d2 s376\n" +
                "d1 d2 s377\n" +
                "d1 d2 s378\n" +
                "d1 d2 s379\n" +
                "d1 d2 s380\n" +
                "d1 d2 s381\n" +
                "d1 d2 s382\n" +
                "d1 d2 s383\n" +
                "d1 d2 s384\n" +
                "d1 d2 s385\n" +
                "d1 d2 s386\n" +
                "d1 d2 s387\n" +
                "d1 d2 s388\n" +
                "d1 d2 s389\n" +
                "d1 d2 s390\n" +
                "d1 d2 s391\n" +
                "d1 d2 s392\n" +
                "d1 d2 s393\n" +
                "d1 d2 s394\n" +
                "d1 d2 s395\n" +
                "d1 d2 s396\n" +
                "d1 d2 s397\n" +
                "d1 d2 s398\n" +
                "d1 d2 s399\n" +
                "d1 d2 s400\n" +
                "d1 d2 s401\n" +
                "d1 d2 s402\n" +
                "d1 d2 s403\n" +
                "d1 d2 s404\n" +
                "d1 d2 s405\n" +
                "d1 d2 s406\n" +
                "d1 d2 s407\n" +
                "d1 d2 s408\n" +
                "d1 d2 s409\n" +
                "d1 d2 s410\n" +
                "d1 d2 s411\n" +
                "d1 d2 s412\n" +
                "d1 d2 s413\n" +
                "d1 d2 s414\n" +
                "d1 d2 s415\n" +
                "d1 d2 s416\n" +
                "d1 d2 s417\n" +
                "d1 d2 s418\n" +
                "d1 d2 s419\n" +
                "d1 d2 s420\n" +
                "d1 d2 s421\n" +
                "d1 d2 s422\n" +
                "d1 d2 s423\n" +
                "d1 d2 s424\n" +
                "d1 d2 s425\n" +
                "d1 d2 s426\n" +
                "d1 d2 s427\n" +
                "d1 d2 s428\n" +
                "d1 d2 s429\n" +
                "d1 d2 s430\n" +
                "d1 d2 s431\n" +
                "d1 d2 s432\n" +
                "d1 d2 s433\n" +
                "d1 d2 s434\n" +
                "d1 d2 s435\n" +
                "d1 d2 s436\n" +
                "d1 d2 s437\n" +
                "d1 d2 s438\n" +
                "d1 d2 s439\n" +
                "d1 d2 s440\n" +
                "d1 d2 s441\n" +
                "d1 d2 s442\n" +
                "d1 d2 s443\n" +
                "d1 d2 s444\n" +
                "d1 d2 s445\n" +
                "d1 d2 s446\n" +
                "d1 d2 s447\n" +
                "d1 d2 s448\n" +
                "d1 d2 s449\n" +
                "d1 d2 s450\n" +
                "d1 d2 s451\n" +
                "d1 d2 s452\n" +
                "d1 d2 s453\n" +
                "d1 d2 s454\n" +
                "d1 d2 s455\n" +
                "d1 d2 s456\n" +
                "d1 d2 s457\n" +
                "d1 d2 s458\n" +
                "d1 d2 s459\n" +
                "d1 d2 s460\n" +
                "d1 d2 s461\n" +
                "d1 d2 s462\n" +
                "d1 d2 s463\n" +
                "d1 d2 s464\n" +
                "d1 d2 s465\n" +
                "d1 d2 s466\n" +
                "d1 d2 s467\n" +
                "d1 d2 s468\n" +
                "d1 d2 s469\n" +
                "d1 d2 s470\n" +
                "d1 d2 s471\n" +
                "d1 d2 s472\n" +
                "d1 d2 s473\n" +
                "d1 d2 s474\n" +
                "d1 d2 s475\n" +
                "d1 d2 s476\n" +
                "d1 d2 s477\n" +
                "d1 d2 s478\n" +
                "d1 d2 s479\n" +
                "d1 d2 s480\n" +
                "d1 d2 s481\n" +
                "d1 d2 s482\n" +
                "d1 d2 s483\n" +
                "d1 d2 s484\n" +
                "d1 d2 s485\n" +
                "d1 d2 s486\n" +
                "d1 d2 s487\n" +
                "d1 d2 s488\n" +
                "d1 d2 s489\n" +
                "d1 d2 s490\n" +
                "d1 d2 s491\n" +
                "d1 d2 s492\n" +
                "d1 d2 s493\n" +
                "d1 d2 s494\n" +
                "d1 d2 s495\n" +
                "d1 d2 s496\n" +
                "d1 d2 s497\n" +
                "d1 d2 s498\n" +
                "d1 d2 s499\n" +
                "d1 d2 s500\n" +
                "d1 d2 s501\n" +
                "d1 d2 s502\n" +
                "d1 d2 s503\n" +
                "d1 d2 s504\n" +
                "d1 d2 s505\n" +
                "d1 d2 s506\n" +
                "d1 d2 s507\n" +
                "d1 d2 s508\n" +
                "d1 d2 s509\n" +
                "d1 d2 s510\n" +
                "d1 d2 s511\n" +
                "d1 d2 s512\n" +
                "d1 d2 s513\n" +
                "d1 d2 s514\n" +
                "d1 d2 s515\n" +
                "d1 d2 s516\n" +
                "d1 d2 s517\n" +
                "d1 d2 s518\n" +
                "d1 d2 s519\n" +
                "d1 d2 s520\n" +
                "d1 d2 s521\n" +
                "d1 d2 s522\n" +
                "d1 d2 s523\n" +
                "d1 d2 s524\n" +
                "d1 d2 s525\n" +
                "d1 d2 s526\n" +
                "d1 d2 s527\n" +
                "d1 d2 s528\n" +
                "d1 d2 s529\n" +
                "d1 d2 s530\n" +
                "d1 d2 s531\n" +
                "d1 d2 s532\n" +
                "d1 d2 s533\n" +
                "d1 d2 s534\n" +
                "d1 d2 s535\n" +
                "d1 d2 s536\n" +
                "d1 d2 s537\n" +
                "d1 d2 s538\n" +
                "d1 d2 s539\n" +
                "d1 d2 s540\n" +
                "d1 d2 s541\n" +
                "d1 d2 s542\n" +
                "d1 d2 s543\n" +
                "d1 d2 s544\n" +
                "d1 d2 s545\n" +
                "d1 d2 s546\n" +
                "d1 d2 s547\n" +
                "d1 d2 s548\n" +
                "d1 d2 s549\n" +
                "d1 d2 s550\n" +
                "d1 d2 s551\n" +
                "d1 d2 s552\n" +
                "d1 d2 s553\n" +
                "d1 d2 s554\n" +
                "d1 d2 s555\n" +
                "d1 d2 s556\n" +
                "d1 d2 s557\n" +
                "d1 d2 s558\n" +
                "d1 d2 s559\n" +
                "d1 d2 s560\n" +
                "d1 d2 s561\n" +
                "d1 d2 s562\n" +
                "d1 d2 s563\n" +
                "d1 d2 s564\n" +
                "d1 d2 s565\n" +
                "d1 d2 s566\n" +
                "d1 d2 s567\n" +
                "d1 d2 s568\n" +
                "d1 d2 s569\n" +
                "d1 d2 s570\n" +
                "d1 d2 s571\n" +
                "d1 d2 s572\n" +
                "d1 d2 s573\n" +
                "d1 d2 s574\n" +
                "d1 d2 s575\n" +
                "d1 d2 s576\n" +
                "d1 d2 s577\n" +
                "d1 d2 s578\n" +
                "d1 d2 s579\n" +
                "d1 d2 s580\n" +
                "d1 d2 s581\n" +
                "d1 d2 s582\n" +
                "d1 d2 s583\n" +
                "d1 d2 s584\n" +
                "d1 d2 s585\n" +
                "d1 d2 s586\n" +
                "d1 d2 s587\n" +
                "d1 d2 s588\n" +
                "d1 d2 s589\n" +
                "d1 d2 s590\n" +
                "d1 d2 s591\n" +
                "d1 d2 s592\n" +
                "d1 d2 s593\n" +
                "d1 d2 s594\n" +
                "d1 d2 s595\n" +
                "d1 d2 s596\n" +
                "d1 d2 s597\n" +
                "d1 d2 s598\n" +
                "d1 d2 s599\n" +
                "d1 d2 s600\n" +
                "d1 d2 s601\n" +
                "d1 d2 s602\n" +
                "d1 d2 s603\n" +
                "d1 d2 s604\n" +
                "d1 d2 s605\n" +
                "d1 d2 s606\n" +
                "d1 d2 s607\n" +
                "d1 d2 s608\n" +
                "d1 d2 s609\n" +
                "d1 d2 s610\n" +
                "d1 d2 s611\n" +
                "d1 d2 s612\n" +
                "d1 d2 s613\n" +
                "d1 d2 s614\n" +
                "d1 d2 s615\n" +
                "d1 d2 s616\n" +
                "d1 d2 s617\n" +
                "d1 d2 s618\n" +
                "d1 d2 s619\n" +
                "d1 d2 s620\n" +
                "d1 d2 s621\n" +
                "d1 d2 s622\n" +
                "d1 d2 s623\n" +
                "d1 d2 s624\n" +
                "d1 d2 s625\n" +
                "d1 d2 s626\n" +
                "d1 d2 s627\n" +
                "d1 d2 s628\n" +
                "d1 d2 s629\n" +
                "d1 d2 s630\n" +
                "d1 d2 s631\n" +
                "d1 d2 s632\n" +
                "d1 d2 s633\n" +
                "d1 d2 s634\n" +
                "d1 d2 s635\n" +
                "d1 d2 s636\n" +
                "d1 d2 s637\n" +
                "d1 d2 s638\n" +
                "d1 d2 s639\n" +
                "d1 d2 s640\n" +
                "d1 d2 s641\n" +
                "d1 d2 s642\n" +
                "d1 d2 s643\n" +
                "d1 d2 s644\n" +
                "d1 d2 s645\n" +
                "d1 d2 s646\n" +
                "d1 d2 s647\n" +
                "d1 d2 s648\n" +
                "d1 d2 s649\n" +
                "d1 d2 s650\n" +
                "d1 d2 s651\n" +
                "d1 d2 s652\n" +
                "d1 d2 s653\n" +
                "d1 d2 s654\n" +
                "d1 d2 s655\n" +
                "d1 d2 s656\n" +
                "d1 d2 s657\n" +
                "d1 d2 s658\n" +
                "d1 d2 s659\n" +
                "d1 d2 s660\n" +
                "d1 d2 s661\n" +
                "d1 d2 s662\n" +
                "d1 d2 s663\n" +
                "d1 d2 s664\n" +
                "d1 d2 s665\n" +
                "d1 d2 s666\n" +
                "d1 d2 s667\n" +
                "d1 d2 s668\n" +
                "d1 d2 s669\n" +
                "d1 d2 s670\n" +
                "d1 d2 s671\n" +
                "d1 d2 s672\n" +
                "d1 d2 s673\n" +
                "d1 d2 s674\n" +
                "d1 d2 s675\n" +
                "d1 d2 s676\n" +
                "d1 d2 s677\n" +
                "d1 d2 s678\n" +
                "d1 d2 s679\n" +
                "d1 d2 s680\n" +
                "d1 d2 s681\n" +
                "d1 d2 s682\n" +
                "d1 d2 s683\n" +
                "d1 d2 s684\n" +
                "d1 d2 s685\n" +
                "d1 d2 s686\n" +
                "d1 d2 s687\n" +
                "d1 d2 s688\n" +
                "d1 d2 s689\n" +
                "d1 d2 s690\n" +
                "d1 d2 s691\n" +
                "d1 d2 s692\n" +
                "d1 d2 s693\n" +
                "d1 d2 s694\n" +
                "d1 d2 s695\n" +
                "d1 d2 s696\n" +
                "d1 d2 s697\n" +
                "d1 d2 s698\n" +
                "d1 d2 s699\n" +
                "d1 d2 s700\n" +
                "d1 d2 s701\n" +
                "d1 d2 s702\n" +
                "d1 d2 s703\n" +
                "d1 d2 s704\n" +
                "d1 d2 s705\n" +
                "d1 d2 s706\n" +
                "d1 d2 s707\n" +
                "d1 d2 s708\n" +
                "d1 d2 s709\n" +
                "d1 d2 s710\n" +
                "d1 d2 s711\n" +
                "d1 d2 s712\n" +
                "d1 d2 s713\n" +
                "d1 d2 s714\n" +
                "d1 d2 s715\n" +
                "d1 d2 s716\n" +
                "d1 d2 s717\n" +
                "d1 d2 s718\n" +
                "d1 d2 s719\n" +
                "d1 d2 s720\n" +
                "d1 d2 s721\n" +
                "d1 d2 s722\n" +
                "d1 d2 s723\n" +
                "d1 d2 s724\n" +
                "d1 d2 s725\n" +
                "d1 d2 s726\n" +
                "d1 d2 s727\n" +
                "d1 d2 s728\n" +
                "d1 d2 s729\n" +
                "d1 d2 s730\n" +
                "d1 d2 s731\n" +
                "d1 d2 s732\n" +
                "d1 d2 s733\n" +
                "d1 d2 s734\n" +
                "d1 d2 s735\n" +
                "d1 d2 s736\n" +
                "d1 d2 s737\n" +
                "d1 d2 s738\n" +
                "d1 d2 s739\n" +
                "d1 d2 s740\n" +
                "d1 d2 s741\n" +
                "d1 d2 s742\n" +
                "d1 d2 s743\n" +
                "d1 d2 s744\n" +
                "d1 d2 s745\n" +
                "d1 d2 s746\n" +
                "d1 d2 s747\n" +
                "d1 d2 s748\n" +
                "d1 d2 s749\n" +
                "d1 d2 s750\n" +
                "d1 d2 s751\n" +
                "d1 d2 s752\n" +
                "d1 d2 s753\n" +
                "d1 d2 s754\n" +
                "d1 d2 s755\n" +
                "d1 d2 s756\n" +
                "d1 d2 s757\n" +
                "d1 d2 s758\n" +
                "d1 d2 s759\n" +
                "d1 d2 s760\n" +
                "d1 d2 s761\n" +
                "d1 d2 s762\n" +
                "d1 d2 s763\n" +
                "d1 d2 s764\n" +
                "d1 d2 s765\n" +
                "d1 d2 s766\n" +
                "d1 d2 s767\n" +
                "d1 d2 s768\n" +
                "d1 d2 s769\n" +
                "d1 d2 s770\n" +
                "d1 d2 s771\n" +
                "d1 d2 s772\n" +
                "d1 d2 s773\n" +
                "d1 d2 s774\n" +
                "d1 d2 s775\n" +
                "d1 d2 s776\n" +
                "d1 d2 s777\n" +
                "d1 d2 s778\n" +
                "d1 d2 s779\n" +
                "d1 d2 s780\n" +
                "d1 d2 s781\n" +
                "d1 d2 s782\n" +
                "d1 d2 s783\n" +
                "d1 d2 s784\n" +
                "d1 d2 s785\n" +
                "d1 d2 s786\n" +
                "d1 d2 s787\n" +
                "d1 d2 s788\n" +
                "d1 d2 s789\n" +
                "d1 d2 s790\n" +
                "d1 d2 s791\n" +
                "d1 d2 s792\n" +
                "d1 d2 s793\n" +
                "d1 d2 s794\n" +
                "d1 d2 s795\n" +
                "d1 d2 s796\n" +
                "d1 d2 s797\n" +
                "d1 d2 s798\n" +
                "d1 d2 s799\n" +
                "d1 d2 s800\n" +
                "d1 d2 s801\n" +
                "d1 d2 s802\n" +
                "d1 d2 s803\n" +
                "d1 d2 s804\n" +
                "d1 d2 s805\n" +
                "d1 d2 s806\n" +
                "d1 d2 s807\n" +
                "d1 d2 s808\n" +
                "d1 d2 s809\n" +
                "d1 d2 s810\n" +
                "d1 d2 s811\n" +
                "d1 d2 s812\n" +
                "d1 d2 s813\n" +
                "d1 d2 s814\n" +
                "d1 d2 s815\n" +
                "d1 d2 s816\n" +
                "d1 d2 s817\n" +
                "d1 d2 s818\n" +
                "d1 d2 s819\n" +
                "d1 d2 s820\n" +
                "d1 d2 s821\n" +
                "d1 d2 s822\n" +
                "d1 d2 s823\n" +
                "d1 d2 s824\n" +
                "d1 d2 s825\n" +
                "d1 d2 s826\n" +
                "d1 d2 s827\n" +
                "d1 d2 s828\n" +
                "d1 d2 s829\n" +
                "d1 d2 s830\n" +
                "d1 d2 s831\n" +
                "d1 d2 s832\n" +
                "d1 d2 s833\n" +
                "d1 d2 s834\n" +
                "d1 d2 s835\n" +
                "d1 d2 s836\n" +
                "d1 d2 s837\n" +
                "d1 d2 s838\n" +
                "d1 d2 s839\n" +
                "d1 d2 s840\n" +
                "d1 d2 s841\n" +
                "d1 d2 s842\n" +
                "d1 d2 s843\n" +
                "d1 d2 s844\n" +
                "d1 d2 s845\n" +
                "d1 d2 s846\n" +
                "d1 d2 s847\n" +
                "d1 d2 s848\n" +
                "d1 d2 s849\n" +
                "d1 d2 s850\n" +
                "d1 d2 s851\n" +
                "d1 d2 s852\n" +
                "d1 d2 s853\n" +
                "d1 d2 s854\n" +
                "d1 d2 s855\n" +
                "d1 d2 s856\n" +
                "d1 d2 s857\n" +
                "d1 d2 s858\n" +
                "d1 d2 s859\n" +
                "d1 d2 s860\n" +
                "d1 d2 s861\n" +
                "d1 d2 s862\n" +
                "d1 d2 s863\n" +
                "d1 d2 s864\n" +
                "d1 d2 s865\n" +
                "d1 d2 s866\n" +
                "d1 d2 s867\n" +
                "d1 d2 s868\n" +
                "d1 d2 s869\n" +
                "d1 d2 s870\n" +
                "d1 d2 s871\n" +
                "d1 d2 s872\n" +
                "d1 d2 s873\n" +
                "d1 d2 s874\n" +
                "d1 d2 s875\n" +
                "d1 d2 s876\n" +
                "d1 d2 s877\n" +
                "d1 d2 s878\n" +
                "d1 d2 s879\n" +
                "d1 d2 s880\n" +
                "d1 d2 s881\n" +
                "d1 d2 s882\n" +
                "d1 d2 s883\n" +
                "d1 d2 s884\n" +
                "d1 d2 s885\n" +
                "d1 d2 s886\n" +
                "d1 d2 s887\n" +
                "d1 d2 s888\n" +
                "d1 d2 s889\n" +
                "d1 d2 s890\n" +
                "d1 d2 s891\n" +
                "d1 d2 s892\n" +
                "d1 d2 s893\n" +
                "d1 d2 s894\n" +
                "d1 d2 s895\n" +
                "d1 d2 s896\n" +
                "d1 d2 s897\n" +
                "d1 d2 s898\n" +
                "d1 d2 s899\n" +
                "d1 d2 s900\n" +
                "d1 d2 s901\n" +
                "d1 d2 s902\n" +
                "d1 d2 s903\n" +
                "d1 d2 s904\n" +
                "d1 d2 s905\n" +
                "d1 d2 s906\n" +
                "d1 d2 s907\n" +
                "d1 d2 s908\n" +
                "d1 d2 s909\n" +
                "d1 d2 s910\n" +
                "d1 d2 s911\n" +
                "d1 d2 s912\n" +
                "d1 d2 s913\n" +
                "d1 d2 s914\n" +
                "d1 d2 s915\n" +
                "d1 d2 s916\n" +
                "d1 d2 s917\n" +
                "d1 d2 s918\n" +
                "d1 d2 s919\n" +
                "d1 d2 s920\n" +
                "d1 d2 s921\n" +
                "d1 d2 s922\n" +
                "d1 d2 s923\n" +
                "d1 d2 s924\n" +
                "d1 d2 s925\n" +
                "d1 d2 s926\n" +
                "d1 d2 s927\n" +
                "d1 d2 s928\n" +
                "d1 d2 s929\n" +
                "d1 d2 s930\n" +
                "d1 d2 s931\n" +
                "d1 d2 s932\n" +
                "d1 d2 s933\n" +
                "d1 d2 s934\n" +
                "d1 d2 s935\n" +
                "d1 d2 s936\n" +
                "d1 d2 s937\n" +
                "d1 d2 s938\n" +
                "d1 d2 s939\n" +
                "d1 d2 s940\n" +
                "d1 d2 s941\n" +
                "d1 d2 s942\n" +
                "d1 d2 s943\n" +
                "d1 d2 s944\n" +
                "d1 d2 s945\n" +
                "d1 d2 s946\n" +
                "d1 d2 s947\n" +
                "d1 d2 s948\n" +
                "d1 d2 s949\n" +
                "d1 d2 s950\n" +
                "d1 d2 s951\n" +
                "d1 d2 s952\n" +
                "d1 d2 s953\n" +
                "d1 d2 s954\n" +
                "d1 d2 s955\n" +
                "d1 d2 s956\n" +
                "d1 d2 s957\n" +
                "d1 d2 s958\n" +
                "d1 d2 s959\n" +
                "d1 d2 s960\n" +
                "d1 d2 s961\n" +
                "d1 d2 s962\n" +
                "d1 d2 s963\n" +
                "d1 d2 s964\n" +
                "d1 d2 s965\n" +
                "d1 d2 s966\n" +
                "d1 d2 s967\n" +
                "d1 d2 s968\n" +
                "d1 d2 s969\n" +
                "d1 d2 s970\n" +
                "d1 d2 s971\n" +
                "d1 d2 s972\n" +
                "d1 d2 s973\n" +
                "d1 d2 s974\n" +
                "d1 d2 s975\n" +
                "d1 d2 s976\n" +
                "d1 d2 s977\n" +
                "d1 d2 s978\n" +
                "d1 d2 s979\n" +
                "d1 d2 s980\n" +
                "d1 d2 s981\n" +
                "d1 d2 s982\n" +
                "d1 d2 s983\n" +
                "d1 d2 s984\n" +
                "d1 d2 s985\n" +
                "d1 d2 s986\n" +
                "d1 d2 s987\n" +
                "d1 d2 s988\n" +
                "d1 d2 s989\n" +
                "d1 d2 s990\n" +
                "d1 d2 s991\n" +
                "d1 d2 s992\n" +
                "d1 d2 s993\n" +
                "d1 d2 s994\n" +
                "d1 d2 s995\n" +
                "d1 d2 s996\n" +
                "d1 d2 s997\n" +
                "d1 d2 s998\n" +
                "d1 d2 s999\n" +
                "d1 d2 s1000\n" +
                "d1 d2 s1001\n" +
                "d1 d2 s1002\n" +
                "d1 d2 s1003\n" +
                "d1 d2 s1004\n" +
                "d1 d2 s1005\n" +
                "d1 d2 s1006\n" +
                "d1 d2 s1007\n" +
                "d1 d2 s1008\n" +
                "d1 d2 s1009\n" +
                "d1 d2 s1010\n" +
                "d1 d2 s1011\n" +
                "d1 d2 s1012\n" +
                "d1 d2 s1013\n" +
                "d1 d2 s1014\n" +
                "d1 d2 s1015\n" +
                "d1 d2 s1016\n" +
                "d1 d2 s1017\n" +
                "d1 d2 s1018\n" +
                "d1 d2 s1019\n" +
                "d1 d2 s1020\n" +
                "d1 d2 s1021\n" +
                "d1 d2 s1022\n" +
                "d1 d2 s1023\n" +
                "d1 d2 s1024\n" +
                "d1 d2 s1025\n" +
                "d1 d2 s1026\n" +
                "d1 d2 s1027\n" +
                "d1 d2 s1028\n" +
                "d1 d2 s1029\n" +
                "d1 d2 s1030\n" +
                "d1 d2 s1031\n" +
                "d1 d2 s1032\n" +
                "d1 d2 s1033\n" +
                "d1 d2 s1034\n" +
                "d1 d2 s1035\n" +
                "d1 d2 s1036\n" +
                "d1 d2 s1037\n" +
                "d1 d2 s1038\n" +
                "d1 d2 s1039\n" +
                "d1 d2 s1040\n" +
                "d1 d2 s1041\n" +
                "d1 d2 s1042\n" +
                "d1 d2 s1043\n" +
                "d1 d2 s1044\n" +
                "d1 d2 s1045\n" +
                "d1 d2 s1046\n" +
                "d1 d2 s1047\n" +
                "d1 d2 s1048\n" +
                "d1 d2 s1049\n" +
                "d1 d2 s1050\n" +
                "d1 d2 s1051\n" +
                "d1 d2 s1052\n" +
                "d1 d2 s1053\n" +
                "d1 d2 s1054\n" +
                "d1 d2 s1055\n" +
                "d1 d2 s1056\n" +
                "d1 d2 s1057\n" +
                "d1 d2 s1058\n" +
                "d1 d2 s1059\n" +
                "d1 d2 s1060\n" +
                "d1 d2 s1061\n" +
                "d1 d2 s1062\n" +
                "d1 d2 s1063\n" +
                "d1 d2 s1064\n" +
                "d1 d2 s1065\n" +
                "d1 d2 s1066\n" +
                "d1 d2 s1067\n" +
                "d1 d2 s1068\n" +
                "d1 d2 s1069\n" +
                "d1 d2 s1070\n" +
                "d1 d2 s1071\n" +
                "d1 d2 s1072\n" +
                "d1 d2 s1073\n" +
                "d1 d2 s1074\n" +
                "d1 d2 s1075\n" +
                "d1 d2 s1076\n" +
                "d1 d2 s1077\n" +
                "d1 d2 s1078\n" +
                "d1 d2 s1079\n" +
                "d1 d2 s1080\n" +
                "d1 d2 s1081\n" +
                "d1 d2 s1082\n" +
                "d1 d2 s1083\n" +
                "d1 d2 s1084\n" +
                "d1 d2 s1085\n" +
                "d1 d2 s1086\n" +
                "d1 d2 s1087\n" +
                "d1 d2 s1088\n" +
                "d1 d2 s1089\n" +
                "d1 d2 s1090\n" +
                "d1 d2 s1091\n" +
                "d1 d2 s1092\n" +
                "d1 d2 s1093\n" +
                "d1 d2 s1094\n" +
                "d1 d2 s1095\n" +
                "d1 d2 s1096\n" +
                "d1 d2 s1097\n" +
                "d1 d2 s1098\n" +
                "d1 d2 s1099\n" +
                "d1 d2 s1100\n" +
                "d1 d2 s1101\n" +
                "d1 d2 s1102\n" +
                "d1 d2 s1103\n" +
                "d1 d2 s1104\n" +
                "d1 d2 s1105\n" +
                "d1 d2 s1106\n" +
                "d1 d2 s1107\n" +
                "d1 d2 s1108\n" +
                "d1 d2 s1109\n" +
                "d1 d2 s1110\n" +
                "d1 d2 s1111\n" +
                "d1 d2 s1112\n" +
                "d1 d2 s1113\n" +
                "d1 d2 s1114\n" +
                "d1 d2 s1115\n" +
                "d1 d2 s1116\n" +
                "d1 d2 s1117\n" +
                "d1 d2 s1118\n" +
                "d1 d2 s1119\n" +
                "d1 d2 s1120\n" +
                "d1 d2 s1121\n" +
                "d1 d2 s1122\n" +
                "d1 d2 s1123\n" +
                "d1 d2 s1124\n" +
                "d1 d2 s1125\n" +
                "d1 d2 s1126\n" +
                "d1 d2 s1127\n" +
                "d1 d2 s1128\n" +
                "d1 d2 s1129\n" +
                "d1 d2 s1130\n" +
                "d1 d2 s1131\n" +
                "d1 d2 s1132\n" +
                "d1 d2 s1133\n" +
                "d1 d2 s1134\n" +
                "d1 d2 s1135\n" +
                "d1 d2 s1136\n" +
                "d1 d2 s1137\n" +
                "d1 d2 s1138\n" +
                "d1 d2 s1139\n" +
                "d1 d2 s1140\n" +
                "d1 d2 s1141\n" +
                "d1 d2 s1142\n" +
                "d1 d2 s1143\n" +
                "d1 d2 s1144\n" +
                "d1 d2 s1145\n" +
                "d1 d2 s1146\n" +
                "d1 d2 s1147\n" +
                "d1 d2 s1148\n" +
                "d1 d2 s1149\n" +
                "d1 d2 s1150\n" +
                "d1 d2 s1151\n" +
                "d1 d2 s1152\n" +
                "d1 d2 s1153\n" +
                "d1 d2 s1154\n" +
                "d1 d2 s1155\n" +
                "d1 d2 s1156\n" +
                "d1 d2 s1157\n" +
                "d1 d2 s1158\n" +
                "d1 d2 s1159\n" +
                "d1 d2 s1160\n" +
                "d1 d2 s1161\n" +
                "d1 d2 s1162\n" +
                "d1 d2 s1163\n" +
                "d1 d2 s1164\n" +
                "d1 d2 s1165\n" +
                "d1 d2 s1166\n" +
                "d1 d2 s1167\n" +
                "d1 d2 s1168\n" +
                "d1 d2 s1169\n" +
                "d1 d2 s1170\n" +
                "d1 d2 s1171\n" +
                "d1 d2 s1172\n" +
                "d1 d2 s1173\n" +
                "d1 d2 s1174\n" +
                "d1 d2 s1175\n" +
                "d1 d2 s1176\n" +
                "d1 d2 s1177\n" +
                "d1 d2 s1178\n" +
                "d1 d2 s1179\n" +
                "d1 d2 s1180\n" +
                "d1 d2 s1181\n" +
                "d1 d2 s1182\n" +
                "d1 d2 s1183\n" +
                "d1 d2 s1184\n" +
                "d1 d2 s1185\n" +
                "d1 d2 s1186\n" +
                "d1 d2 s1187\n" +
                "d1 d2 s1188\n" +
                "d1 d2 s1189\n" +
                "d1 d2 s1190\n" +
                "d1 d2 s1191\n" +
                "d1 d2 s1192\n" +
                "d1 d2 s1193\n" +
                "d1 d2 s1194\n" +
                "d1 d2 s1195\n" +
                "d1 d2 s1196\n" +
                "d1 d2 s1197\n" +
                "d1 d2 s1198\n" +
                "d1 d2 s1199\n" +
                "d1 d2 s1200\n" +
                "d1 d2 s1201\n" +
                "d1 d2 s1202\n" +
                "d1 d2 s1203\n" +
                "d1 d2 s1204\n" +
                "d1 d2 s1205\n" +
                "d1 d2 s1206\n" +
                "d1 d2 s1207\n" +
                "d1 d2 s1208\n" +
                "d1 d2 s1209\n" +
                "d1 d2 s1210\n" +
                "d1 d2 s1211\n" +
                "d1 d2 s1212\n" +
                "d1 d2 s1213\n" +
                "d1 d2 s1214\n" +
                "d1 d2 s1215\n" +
                "d1 d2 s1216\n" +
                "d1 d2 s1217\n" +
                "d1 d2 s1218\n" +
                "d1 d2 s1219\n" +
                "d1 d2 s1220\n" +
                "d1 d2 s1221\n" +
                "d1 d2 s1222\n" +
                "d1 d2 s1223\n" +
                "d1 d2 s1224\n" +
                "d1 d2 s1225\n" +
                "d1 d2 s1226\n" +
                "d1 d2 s1227\n" +
                "d1 d2 s1228\n" +
                "d1 d2 s1229\n" +
                "d1 d2 s1230\n" +
                "d1 d2 s1231\n" +
                "d1 d2 s1232\n" +
                "d1 d2 s1233\n" +
                "d1 d2 s1234\n" +
                "d1 d2 s1235\n" +
                "d1 d2 s1236\n" +
                "d1 d2 s1237\n" +
                "d1 d2 s1238\n" +
                "d1 d2 s1239\n" +
                "d1 d2 s1240\n" +
                "d1 d2 s1241\n" +
                "d1 d2 s1242\n" +
                "d1 d2 s1243\n" +
                "d1 d2 s1244\n" +
                "d1 d2 s1245\n" +
                "d1 d2 s1246\n" +
                "d1 d2 s1247\n" +
                "d1 d2 s1248\n" +
                "d1 d2 s1249\n" +
                "d1 d2 s1250\n" +
                "d1 d2 s1251\n" +
                "d1 d2 s1252\n" +
                "d1 d2 s1253\n" +
                "d1 d2 s1254\n" +
                "d1 d2 s1255\n" +
                "d1 d2 s1256\n" +
                "d1 d2 s1257\n" +
                "d1 d2 s1258\n" +
                "d1 d2 s1259\n" +
                "d1 d2 s1260\n" +
                "d1 d2 s1261\n" +
                "d1 d2 s1262\n" +
                "d1 d2 s1263\n" +
                "d1 d2 s1264\n" +
                "d1 d2 s1265\n" +
                "d1 d2 s1266\n" +
                "d1 d2 s1267\n" +
                "d1 d2 s1268\n" +
                "d1 d2 s1269\n" +
                "d1 d2 s1270\n" +
                "d1 d2 s1271\n" +
                "d1 d2 s1272\n" +
                "d1 d2 s1273\n" +
                "d1 d2 s1274\n" +
                "d1 d2 s1275\n" +
                "d1 d2 s1276\n" +
                "d1 d2 s1277\n" +
                "d1 d2 s1278\n" +
                "d1 d2 s1279\n" +
                "d1 d2 s1280\n" +
                "d1 d2 s1281\n" +
                "d1 d2 s1282\n" +
                "d1 d2 s1283\n" +
                "d1 d2 s1284\n" +
                "d1 d2 s1285\n" +
                "d1 d2 s1286\n" +
                "d1 d2 s1287\n" +
                "d1 d2 s1288\n" +
                "d1 d2 s1289\n" +
                "d1 d2 s1290\n" +
                "d1 d2 s1291\n" +
                "d1 d2 s1292\n" +
                "d1 d2 s1293\n" +
                "d1 d2 s1294\n" +
                "d1 d2 s1295\n" +
                "d1 d2 s1296\n" +
                "d1 d2 s1297\n" +
                "d1 d2 s1298\n" +
                "d1 d2 s1299\n" +
                "d1 d2 s1300\n" +
                "d1 d2 s1301\n" +
                "d1 d2 s1302\n" +
                "d1 d2 s1303\n" +
                "d1 d2 s1304\n" +
                "d1 d2 s1305\n" +
                "d1 d2 s1306\n" +
                "d1 d2 s1307\n" +
                "d1 d2 s1308\n" +
                "d1 d2 s1309\n" +
                "d1 d2 s1310\n" +
                "d1 d2 s1311\n" +
                "d1 d2 s1312\n" +
                "d1 d2 s1313\n" +
                "d1 d2 s1314\n" +
                "d1 d2 s1315\n" +
                "d1 d2 s1316\n" +
                "d1 d2 s1317\n" +
                "d1 d2 s1318\n" +
                "d1 d2 s1319\n" +
                "d1 d2 s1320\n" +
                "d1 d2 s1321\n" +
                "d1 d2 s1322\n" +
                "d1 d2 s1323\n" +
                "d1 d2 s1324\n" +
                "d1 d2 s1325\n" +
                "d1 d2 s1326\n" +
                "d1 d2 s1327\n" +
                "d1 d2 s1328\n" +
                "d1 d2 s1329\n" +
                "d1 d2 s1330\n" +
                "d1 d2 s1331\n" +
                "d1 d2 s1332\n" +
                "d1 d2 s1333\n" +
                "d1 d2 s1334\n" +
                "d1 d2 s1335\n" +
                "d1 d2 s1336\n" +
                "d1 d2 s1337\n" +
                "d1 d2 s1338\n" +
                "d1 d2 s1339\n" +
                "d1 d2 s1340\n" +
                "d1 d2 s1341\n" +
                "d1 d2 s1342\n" +
                "d1 d2 s1343\n" +
                "d1 d2 s1344\n" +
                "d1 d2 s1345\n" +
                "d1 d2 s1346\n" +
                "d1 d2 s1347\n" +
                "d1 d2 s1348\n" +
                "d1 d2 s1349\n" +
                "d1 d2 s1350\n" +
                "d1 d2 s1351\n" +
                "d1 d2 s1352\n" +
                "d1 d2 s1353\n" +
                "d1 d2 s1354\n" +
                "d1 d2 s1355\n" +
                "d1 d2 s1356\n" +
                "d1 d2 s1357\n" +
                "d1 d2 s1358\n" +
                "d1 d2 s1359\n" +
                "d1 d2 s1360\n" +
                "d1 d2 s1361\n" +
                "d1 d2 s1362\n" +
                "d1 d2 s1363\n" +
                "d1 d2 s1364\n" +
                "d1 d2 s1365\n" +
                "d1 d2 s1366\n" +
                "d1 d2 s1367\n" +
                "d1 d2 s1368\n" +
                "d1 d2 s1369\n" +
                "d1 d2 s1370\n" +
                "d1 d2 s1371\n" +
                "d1 d2 s1372\n" +
                "d1 d2 s1373\n" +
                "d1 d2 s1374\n" +
                "d1 d2 s1375\n" +
                "d1 d2 s1376\n" +
                "d1 d2 s1377\n" +
                "d1 d2 s1378\n" +
                "d1 d2 s1379\n" +
                "d1 d2 s1380\n" +
                "d1 d2 s1381\n" +
                "d1 d2 s1382\n" +
                "d1 d2 s1383\n" +
                "d1 d2 s1384\n" +
                "d1 d2 s1385\n" +
                "d1 d2 s1386\n" +
                "d1 d2 s1387\n" +
                "d1 d2 s1388\n" +
                "d1 d2 s1389\n" +
                "d1 d2 s1390\n" +
                "d1 d2 s1391\n" +
                "d1 d2 s1392\n" +
                "d1 d2 s1393\n" +
                "d1 d2 s1394\n" +
                "d1 d2 s1395\n" +
                "d1 d2 s1396\n" +
                "d1 d2 s1397\n" +
                "d1 d2 s1398\n" +
                "d1 d2 s1399\n" +
                "d1 d2 s1400\n" +
                "d1 d2 s1401\n" +
                "d1 d2 s1402\n" +
                "d1 d2 s1403\n" +
                "d1 d2 s1404\n" +
                "d1 d2 s1405\n" +
                "d1 d2 s1406\n" +
                "d1 d2 s1407\n" +
                "d1 d2 s1408\n" +
                "d1 d2 s1409\n" +
                "d1 d2 s1410\n" +
                "d1 d2 s1411\n" +
                "d1 d2 s1412\n" +
                "d1 d2 s1413\n" +
                "d1 d2 s1414\n" +
                "d1 d2 s1415\n" +
                "d1 d2 s1416\n" +
                "d1 d2 s1417\n" +
                "d1 d2 s1418\n" +
                "d1 d2 s1419\n" +
                "d1 d2 s1420\n" +
                "d1 d2 s1421\n" +
                "d1 d2 s1422\n" +
                "d1 d2 s1423\n" +
                "d1 d2 s1424\n" +
                "d1 d2 s1425\n" +
                "d1 d2 s1426\n" +
                "d1 d2 s1427\n" +
                "d1 d2 s1428\n" +
                "d1 d2 s1429\n" +
                "d1 d2 s1430\n" +
                "d1 d2 s1431\n" +
                "d1 d2 s1432\n" +
                "d1 d2 s1433\n" +
                "d1 d2 s1434\n" +
                "d1 d2 s1435\n" +
                "d1 d2 s1436\n" +
                "d1 d2 s1437\n" +
                "d1 d2 s1438\n" +
                "d1 d2 s1439\n" +
                "d1 d2 s1440\n" +
                "d1 d2 s1441\n" +
                "d1 d2 s1442\n" +
                "d1 d2 s1443\n" +
                "d1 d2 s1444\n" +
                "d1 d2 s1445\n" +
                "d1 d2 s1446\n" +
                "d1 d2 s1447\n" +
                "d1 d2 s1448\n" +
                "d1 d2 s1449\n" +
                "d1 d2 s1450\n" +
                "d1 d2 s1451\n" +
                "d1 d2 s1452\n" +
                "d1 d2 s1453\n" +
                "d1 d2 s1454\n" +
                "d1 d2 s1455\n" +
                "d1 d2 s1456\n" +
                "d1 d2 s1457\n" +
                "d1 d2 s1458\n" +
                "d1 d2 s1459\n" +
                "d1 d2 s1460\n" +
                "d1 d2 s1461\n" +
                "d1 d2 s1462\n" +
                "d1 d2 s1463\n" +
                "d1 d2 s1464\n" +
                "d1 d2 s1465\n" +
                "d1 d2 s1466\n" +
                "d1 d2 s1467\n" +
                "d1 d2 s1468\n" +
                "d1 d2 s1469\n" +
                "d1 d2 s1470\n" +
                "d1 d2 s1471\n" +
                "d1 d2 s1472\n" +
                "d1 d2 s1473\n" +
                "d1 d2 s1474\n" +
                "d1 d2 s1475\n" +
                "d1 d2 s1476\n" +
                "d1 d2 s1477\n" +
                "d1 d2 s1478\n" +
                "d1 d2 s1479\n" +
                "d1 d2 s1480\n" +
                "d1 d2 s1481\n" +
                "d1 d2 s1482\n" +
                "d1 d2 s1483\n" +
                "d1 d2 s1484\n" +
                "d1 d2 s1485\n" +
                "d1 d2 s1486\n" +
                "d1 d2 s1487\n" +
                "d1 d2 s1488\n" +
                "d1 d2 s1489\n" +
                "d1 d2 s1490\n" +
                "d1 d2 s1491\n" +
                "d1 d2 s1492\n" +
                "d1 d2 s1493\n" +
                "d1 d2 s1494\n" +
                "d1 d2 s1495\n" +
                "d1 d2 s1496\n" +
                "d1 d2 s1497\n" +
                "d1 d2 s1498\n" +
                "d1 d2 s1499\n" +
                "d1 d2 s1500\n" +
                "d1 d2 s1501\n" +
                "d1 d2 s1502\n" +
                "d1 d2 s1503\n" +
                "d1 d2 s1504\n" +
                "d1 d2 s1505\n" +
                "d1 d2 s1506\n" +
                "d1 d2 s1507\n" +
                "d1 d2 s1508\n" +
                "d1 d2 s1509\n" +
                "d1 d2 s1510\n" +
                "d1 d2 s1511\n" +
                "d1 d2 s1512\n" +
                "d1 d2 s1513\n" +
                "d1 d2 s1514\n" +
                "d1 d2 s1515\n" +
                "d1 d2 s1516\n" +
                "d1 d2 s1517\n" +
                "d1 d2 s1518\n" +
                "d1 d2 s1519\n" +
                "d1 d2 s1520\n" +
                "d1 d2 s1521\n" +
                "d1 d2 s1522\n" +
                "d1 d2 s1523\n" +
                "d1 d2 s1524\n" +
                "d1 d2 s1525\n" +
                "d1 d2 s1526\n" +
                "d1 d2 s1527\n" +
                "d1 d2 s1528\n" +
                "d1 d2 s1529\n" +
                "d1 d2 s1530\n" +
                "d1 d2 s1531\n" +
                "d1 d2 s1532\n" +
                "d1 d2 s1533\n" +
                "d1 d2 s1534\n" +
                "d1 d2 s1535\n" +
                "d1 d2 s1536\n" +
                "d1 d2 s1537\n" +
                "d1 d2 s1538\n" +
                "d1 d2 s1539\n" +
                "d1 d2 s1540\n" +
                "d1 d2 s1541\n" +
                "d1 d2 s1542\n" +
                "d1 d2 s1543\n" +
                "d1 d2 s1544\n" +
                "d1 d2 s1545\n" +
                "d1 d2 s1546\n" +
                "d1 d2 s1547\n" +
                "d1 d2 s1548\n" +
                "d1 d2 s1549\n" +
                "d1 d2 s1550\n" +
                "d1 d2 s1551\n" +
                "d1 d2 s1552\n" +
                "d1 d2 s1553\n" +
                "d1 d2 s1554\n" +
                "d1 d2 s1555\n" +
                "d1 d2 s1556\n" +
                "d1 d2 s1557\n" +
                "d1 d2 s1558\n" +
                "d1 d2 s1559\n" +
                "d1 d2 s1560\n" +
                "d1 d2 s1561\n" +
                "d1 d2 s1562\n" +
                "d1 d2 s1563\n" +
                "d1 d2 s1564\n" +
                "d1 d2 s1565\n" +
                "d1 d2 s1566\n" +
                "d1 d2 s1567\n" +
                "d1 d2 s1568\n" +
                "d1 d2 s1569\n" +
                "d1 d2 s1570\n" +
                "d1 d2 s1571\n" +
                "d1 d2 s1572\n" +
                "d1 d2 s1573\n" +
                "d1 d2 s1574\n" +
                "d1 d2 s1575\n" +
                "d1 d2 s1576\n" +
                "d1 d2 s1577\n" +
                "d1 d2 s1578\n" +
                "d1 d2 s1579\n" +
                "d1 d2 s1580\n" +
                "d1 d2 s1581\n" +
                "d1 d2 s1582\n" +
                "d1 d2 s1583\n" +
                "d1 d2 s1584\n" +
                "d1 d2 s1585\n" +
                "d1 d2 s1586\n" +
                "d1 d2 s1587\n" +
                "d1 d2 s1588\n" +
                "d1 d2 s1589\n" +
                "d1 d2 s1590\n" +
                "d1 d2 s1591\n" +
                "d1 d2 s1592\n" +
                "d1 d2 s1593\n" +
                "d1 d2 s1594\n" +
                "d1 d2 s1595\n" +
                "d1 d2 s1596\n" +
                "d1 d2 s1597\n" +
                "d1 d2 s1598\n" +
                "d1 d2 s1599\n" +
                "d1 d2 s1600\n" +
                "d1 d2 s1601\n" +
                "d1 d2 s1602\n" +
                "d1 d2 s1603\n" +
                "d1 d2 s1604\n" +
                "d1 d2 s1605\n" +
                "d1 d2 s1606\n" +
                "d1 d2 s1607\n" +
                "d1 d2 s1608\n" +
                "d1 d2 s1609\n" +
                "d1 d2 s1610\n" +
                "d1 d2 s1611\n" +
                "d1 d2 s1612\n" +
                "d1 d2 s1613\n" +
                "d1 d2 s1614\n" +
                "d1 d2 s1615\n" +
                "d1 d2 s1616\n" +
                "d1 d2 s1617\n" +
                "d1 d2 s1618\n" +
                "d1 d2 s1619\n" +
                "d1 d2 s1620\n" +
                "d1 d2 s1621\n" +
                "d1 d2 s1622\n" +
                "d1 d2 s1623\n" +
                "d1 d2 s1624\n" +
                "d1 d2 s1625\n" +
                "d1 d2 s1626\n" +
                "d1 d2 s1627\n" +
                "d1 d2 s1628\n" +
                "d1 d2 s1629\n" +
                "d1 d2 s1630\n" +
                "d1 d2 s1631\n" +
                "d1 d2 s1632\n" +
                "d1 d2 s1633\n" +
                "d1 d2 s1634\n" +
                "d1 d2 s1635\n" +
                "d1 d2 s1636\n" +
                "d1 d2 s1637\n" +
                "d1 d2 s1638\n" +
                "d1 d2 s1639\n" +
                "d1 d2 s1640\n" +
                "d1 d2 s1641\n" +
                "d1 d2 s1642\n" +
                "d1 d2 s1643\n" +
                "d1 d2 s1644\n" +
                "d1 d2 s1645\n" +
                "d1 d2 s1646\n" +
                "d1 d2 s1647\n" +
                "d1 d2 s1648\n" +
                "d1 d2 s1649\n" +
                "d1 d2 s1650\n" +
                "d1 d2 s1651\n" +
                "d1 d2 s1652\n" +
                "d1 d2 s1653\n" +
                "d1 d2 s1654\n" +
                "d1 d2 s1655\n" +
                "d1 d2 s1656\n" +
                "d1 d2 s1657\n" +
                "d1 d2 s1658\n" +
                "d1 d2 s1659\n" +
                "d1 d2 s1660\n" +
                "d1 d2 s1661\n" +
                "d1 d2 s1662\n" +
                "d1 d2 s1663\n" +
                "d1 d2 s1664\n" +
                "d1 d2 s1665\n" +
                "d1 d2 s1666\n" +
                "d1 d2 s1667\n" +
                "d1 d2 s1668\n" +
                "d1 d2 s1669\n" +
                "d1 d2 s1670\n" +
                "d1 d2 s1671\n" +
                "d1 d2 s1672\n" +
                "d1 d2 s1673\n" +
                "d1 d2 s1674\n" +
                "d1 d2 s1675\n" +
                "d1 d2 s1676\n" +
                "d1 d2 s1677\n" +
                "d1 d2 s1678\n" +
                "d1 d2 s1679\n" +
                "d1 d2 s1680\n" +
                "d1 d2 s1681\n" +
                "d1 d2 s1682\n" +
                "d1 d2 s1683\n" +
                "d1 d2 s1684\n" +
                "d1 d2 s1685\n" +
                "d1 d2 s1686\n" +
                "d1 d2 s1687\n" +
                "d1 d2 s1688\n" +
                "d1 d2 s1689\n" +
                "d1 d2 s1690\n" +
                "d1 d2 s1691\n" +
                "d1 d2 s1692\n" +
                "d1 d2 s1693\n" +
                "d1 d2 s1694\n" +
                "d1 d2 s1695\n" +
                "d1 d2 s1696\n" +
                "d1 d2 s1697\n" +
                "d1 d2 s1698\n" +
                "d1 d2 s1699\n" +
                "d1 d2 s1700\n" +
                "d1 d2 s1701\n" +
                "d1 d2 s1702\n" +
                "d1 d2 s1703\n" +
                "d1 d2 s1704\n" +
                "d1 d2 s1705\n" +
                "d1 d2 s1706\n" +
                "d1 d2 s1707\n" +
                "d1 d2 s1708\n" +
                "d1 d2 s1709\n" +
                "d1 d2 s1710\n" +
                "d1 d2 s1711\n" +
                "d1 d2 s1712\n" +
                "d1 d2 s1713\n" +
                "d1 d2 s1714\n" +
                "d1 d2 s1715\n" +
                "d1 d2 s1716\n" +
                "d1 d2 s1717\n" +
                "d1 d2 s1718\n" +
                "d1 d2 s1719\n" +
                "d1 d2 s1720\n" +
                "d1 d2 s1721\n" +
                "d1 d2 s1722\n" +
                "d1 d2 s1723\n" +
                "d1 d2 s1724\n" +
                "d1 d2 s1725\n" +
                "d1 d2 s1726\n" +
                "d1 d2 s1727\n" +
                "d1 d2 s1728\n" +
                "d1 d2 s1729\n" +
                "d1 d2 s1730\n" +
                "d1 d2 s1731\n" +
                "d1 d2 s1732\n" +
                "d1 d2 s1733\n" +
                "d1 d2 s1734\n" +
                "d1 d2 s1735\n" +
                "d1 d2 s1736\n" +
                "d1 d2 s1737\n" +
                "d1 d2 s1738\n" +
                "d1 d2 s1739\n" +
                "d1 d2 s1740\n" +
                "d1 d2 s1741\n" +
                "d1 d2 s1742\n" +
                "d1 d2 s1743\n" +
                "d1 d2 s1744\n" +
                "d1 d2 s1745\n" +
                "d1 d2 s1746\n" +
                "d1 d2 s1747\n" +
                "d1 d2 s1748\n" +
                "d1 d2 s1749\n" +
                "d1 d2 s1750\n" +
                "d1 d2 s1751\n" +
                "d1 d2 s1752\n" +
                "d1 d2 s1753\n" +
                "d1 d2 s1754\n" +
                "d1 d2 s1755\n" +
                "d1 d2 s1756\n" +
                "d1 d2 s1757\n" +
                "d1 d2 s1758\n" +
                "d1 d2 s1759\n" +
                "d1 d2 s1760\n" +
                "d1 d2 s1761\n" +
                "d1 d2 s1762\n" +
                "d1 d2 s1763\n" +
                "d1 d2 s1764\n" +
                "d1 d2 s1765\n" +
                "d1 d2 s1766\n" +
                "d1 d2 s1767\n" +
                "d1 d2 s1768\n" +
                "d1 d2 s1769";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}

