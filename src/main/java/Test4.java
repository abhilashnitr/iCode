import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test4 {

    public static void main(String[] args) throws IOException {

        int[] activelist={1417,1416,1415,1414,1413,1412,1410,1409,1408,1407,1406,1405,1404,1403,1402,1401,1400,1399,1398,1397,1396,1395,1394,1393,1392
                ,1391,1390,1389,1388,1387,1386,1385,1384,1382,1381,1379,1377,1372,1369,1368,1365,1364,1363,1362,1360,1359,1358,1357,1356,1353,
                1352,1351,1350,1349,1348,1347,1346,1345,1344,1343,1342,1338,1333,1331,1328,1327,1326,1325,1324,1323,1322,1321,1320,1319,1318,
                1317,1309,1308,1307,1306,1305,1304,1303,1302,1300,1299,1298,1297,1296,1295,1294,1293,1292,1291,1290,1289,1288,1287,1286,1285
                ,1284,1283,1282,1281,1280,1279,1278,1277,1276,1275,1274,1271,1270,1269,1268,1267,1265,1263,1262,1261,1260,1259,1258,1256,1255
                ,1254,1253,1252,1251,1250,1249,1248,1247,1246,1245,1244,1242,1241,1240,1239,1238,1237,1234,1233,1231,1228,1227,1226,1224,1223
                ,1222,1221,1220,1219,1216,1215,1214,1213,1212,1211,1210,1209,1208,1207,1206,1205,1204,1203,1202,1201,1197,1194,1193,1192,1190
                ,1186,1185,1184,1183,1102};

        Set<Integer> set=new HashSet<>();
        for(int a:activelist)set.add(a);

        String updateList=getPublicString();
        String[] updateQuery=updateList.split("\n");
        List<String> alreadyactive=new ArrayList<>();
        for(String query:updateQuery)
        {
            String id=null;
            String lat=null;
            String lon=null;
            String isActive=null;
            String[] s=query.split("\t");
            for(String st:s){
                if(st.length()>0){
                    if(id==null)
                        id=st.trim();
                    else if(lat==null)
                        lat=st.trim();
                    else if(lon==null)
                        lon=st.trim();
                    else
                        isActive=st.trim();
                }
            }
            if(!set.contains(Integer.valueOf(id))) {
                alreadyactive.add(id);
                //  System.out.println(id + " " + lat + " " + lon + " " + isActive);

                String insertQuery = "INSERT INTO `asset`.`location`(`created_by`,`created_timestamp`,`is_active`,`last_updated_by`,`last_updated_timestamp`,`contact_number`,`contact_person`,`is_hub`,`is_inventory_present`,`is_service_centre`,`name`,`coordinate`,`tenant_id`,`is_sm_location`,`vendor`,`pi_vehicle_limit`)\n" +
                        "VALUES(\"A\",1622795192000,1,\"A\",1622795192000,\"7733999944 / 7417414021110\",\"Fleeca Team\",0,0,1,\"Fleeca Center 99999\",ST_GeomFromText( 'POINT( 3 3 )', 0 ),1,0,\"FLEECA\",\"10\");";
                String replaced1 = insertQuery.replace("99999", id);
                String replaced2 = replaced1.replace("POINT( 3 3 )", "POINT( "+lon+" "+lat+" )");
                System.out.println(replaced2);

            }
        }
        System.out.println(alreadyactive.size());




    }

    public static String getPublicString(){
        return  "1631\t\t25.071612\t75.584455\t\t\tActive\n" +
                "1630\t\t25.08985\t 75.63797\t\t\tActive\n" +
                "1629\t\t25.201931\t75.746271\t\t\tActive\n" +
                "1628\t\t25.152766\t75.756328\t\t\tActive\n" +
                "1627\t\t25.108492\t74.92996\t\t\tActive\n" +
                "1626\t\t25.16942\t 76.04449\t\t\tActive\n" +
                "1625\t\t25.147915\t76.241344\t\t\tActive\n" +
                "1624\t\t25.147931\t76.241345\t\t\tActive\n" +
                "1623\t\t25.079084\t76.491033\t\t\tActive\n" +
                "1622\t\t25.16573\t 76.197526\t\t\tActive\n" +
                "1621\t\t25.053124\t76.538524\t\t\tActive\n" +
                "1620\t\t24.965184\t76.59358\t\t\tActive\n" +
                "1619\t\t25.288913\t75.751598\t\t\tActive\n" +
                "1618\t\t25.576531\t75.493353\t\t\tActive\n" +
                "1617\t\t25.639961\t75.4659\t\t\t    Active\n" +
                "1616\t\t25.458813\t75.592674\t\t\tActive\n" +
                "1615\t\t25.680711\t75.439352\t\t\tActive\n" +
                "1614\t\t25.50632\t 75.540772\t\t\tActive\n" +
                "1613\t\t25.381808\t75.670088\t\t\tActive\n" +
                "1612\t\t25.761652\t75.400219\t\t\tActive\n" +
                "1611\t\t25.868075\t75.549224\t\t\tActive\n" +
                "1610\t\t26.005284\t75.681386\t\t\tActive\n" +
                "1609\t\t26.178098\t75.812632\t\t\tActive\n" +
                "1608\t\t26.149088\t75.791905\t\t\tActive\n" +
                "1607\t\t26.546354\t75.947935\t\t\tActive\n" +
                "1606\t\t26.828858\t75.73396\t\t\tActive\n" +
                "1605\t\t27.795784\t76.236999\t\t\tActive\n" +
                "1604\t\t27.452974\t76.021351\t\t\tActive\n" +
                "1603\t\t27.411847\t75.995407\t\t\tActive\n" +
                "1602\t\t27.662672\t76.152196\t\t\tActive\n" +
                "1601\t\t27.408403\t75.994093\t\t\tActive\n" +
                "1600\t\t27.236867\t75.949459\t\t\tActive\n" +
                "1599\t\t27.485001\t76.051159\t\t\tActive\n" +
                "1598\t\t18.487058\t74.016138\t\t\tActive\n" +
                "1597\t\t25.97621\t 75.957804\t\t\tActive\n" +
                "1596\t\t26.56235\t 75.298348\t\t\tActive\n" +
                "1595\t\t26.644381\t77.595869\t\t\tActive\n" +
                "1594\t\t27.189747\t77.453538\t\t\tActive\n" +
                "1593\t\t26.9148\t  76.455161\t\t\tActive\n" +
                "1592\t\t27.16304\t 77.315414\t\t\tActive\n" +
                "1591\t\t26.47867\t 76.757199\t\t\tActive\n" +
                "1590\t\t18.0005449\t73.46527\t\t\tActive\n" +
                "1589\t\t18.6929343\t73.051074\t\t\tActive\n" +
                "1588\t\t26.007459\t76.341711\t\t\tActive\n" +
                "1586\t\t26.87767\t 76.214611\t\t\tActive\n" +
                "1585\t\t27.053782\t76.944044\t\t\tActive\n" +
                "1584\t\t27.054015\t76.943741\t\t\tActive\n" +
                "1583\t\t26.487481\t76.432583\t\t\tActive\n" +
                "1582\t\t26.312989\t76.385482\t\t\tActive\n" +
                "1581\t\t26.590648\t76.329668\t\t\tActive\n" +
                "1580\t\t21.086323\t72.949279\t\t\tActive\n" +
                "1579\t\t25.63961\t 76.18606\t\t\tActive\n" +
                "1578\t\t16.4620824\t79.9169391\t\t\tActive\n" +
                "1577\t\t26.575775\t75.643203\t\t\tActive\n" +
                "1576\t\t26.571536\t75.557311\t\t\tActive\n" +
                "1575\t\t23.99983\t 73.640529\t\t\tActive\n" +
                "1574\t\t15.942701\t74.524296\t\t\tActive\n" +
                "1573\t\t26.426337\t75.93734\t\t\tActive\n" +
                "1572\t\t26.369763\t75.947809\t\t\tActive\n" +
                "1571\t\t26.25015\t 75.85745\t\t\tActive\n" +
                "1570\t\t26.063596\t75.861785\t\t\tActive\n" +
                "1569\t\t26.814614\t75.503199\t\t\tActive\n" +
                "1568\t\t26.668426\t75.931038\t\t\tActive\n" +
                "1567\t\t27.552248\t76.074314\t\t\tActive\n" +
                "1566\t\t27.652699\t76.140874\t\t\tActive\n" +
                "1565\t\t26.823955\t75.550581\t\t\tActive\n" +
                "1564\t\t27.657779\t76.130921\t\t\tActive\n" +
                "1563\t\t21.714724\t85.70893\t\t\tActive\n" +
                "1562\t\t18.525475\t72.94817\t\t\tActive\n" +
                "1561\t\t22.388784\t69.864412\t\t\tActive\n" +
                "1560\t\t26.994794\t75.768051\t\t\tActive\n" +
                "1559\t\t23.846996\t86.452282\t\t\tActive\n" +
                "1557\t\t27.100652\t75.839876\t\t\tActive\n" +
                "1556\t\t27.3711257\t75.9570972\t\t\tActive\n" +
                "1555\t\t27.10033\t 75.839488\t\t\tActive\n" +
                "1554\t\t28.4054132\t76.9836947\t\t\tActive\n" +
                "1553\t\t17.602907\t78.479322\t\t\tActive\n" +
                "1552\t\t17.615258\t78.486069\t\t\tActive\n" +
                "1551\t\t17.620067\t78.4863826\t\t\tActive\n" +
                "1550\t\t25.9058932\t73.47279\t\t\tActive\n" +
                "1549\t\t15.0993794\t76.5432532\t\t\tActive\n" +
                "1548\t\t25.3452792\t74.5576986\t\t\tActive\n" +
                "1547\t\t28.2651837\t76.8301526\t\t\tActive\n" +
                "1546\t\t15.19751\t 76.77204\t\t\tActive\n" +
                "1544\t\t25.569599\t78.494195\t\t\tActive\n" +
                "1543\t\t15.088254\t77.650667\t\t\tActive\n" +
                "1542\t\t25.603676\t77.733107\t\t\tActive\n" +
                "1541\t\t13.152731\t77.338098\t\t\tActive\n" +
                "1540\t\t13.058364\t77.466175\t\t\tActive\n" +
                "1539\t\t18.962388\t73.163971\t\t\tActive\n" +
                "1538\t\t22.5966667\t75.693205\t\t\tActive\n" +
                "1537\t\t28.1388893\t76.8162381\t\t\tActive\n" +
                "1535\t\t28.2651837\t76.8301526\t\t\tActive\n" +
                "1534\t\t26.831528\t75.577746\t\t\tActive\n" +
                "1533\t\t19.106296\t77.324034\t\t\tActive\n" +
                "1532\t\t25.856085\t74.703527\t\t\tActive\n" +
                "1531\t\t27.335411\t77.738953\t\t\tActive\n" +
                "1530\t\t19.255025\t73.044189\t\t\tActive\n" +
                "1529\t\t26.7522829\t83.2249937\t\t\tActive\n" +
                "1528\t\t19.5902486\t78.4906371\t\t\tActive\n" +
                "1527\t\t19.866194\t75.247442\t\t\tActive\n" +
                "1526\t\t13.757238\t77.785896\t\t\tActive\n" +
                "1525\t\t24.272435\t87.8861694\t\t\tActive\n" +
                "1524\t\t21.136665\t78.903678\t\t\tActive\n" +
                "1523\t\t25.6510465\t74.5997734\t\t\tActive\n" +
                "1522\t\t24.9569433\t74.6282867\t\t\tActive\n" +
                "1521\t\t24.7488146\t74.4729693\t\t\tActive\n" +
                "1520\t\t24.612955\t74.2559775\t\t\tActive\n" +
                "1519\t\t24.7080356\t74.3608219\t\t\tActive\n" +
                "1518\t\t24.8694785\t74.5857871\t\t\tActive\n" +
                "1517\t\t24.8748072\t74.3088912\t\t\tActive\n" +
                "1516\t\t24.8514342\t74.2088645\t\t\tActive\n" +
                "1515\t\t24.4092952\t73.6295776\t\t\tActive\n" +
                "1514\t\t24.6591163\t73.8727718\t\t\tActive\n" +
                "1513\t\t24.8223355\t74.0876516\t\t\tActive\n" +
                "1512\t\t24.9634552\t74.1325736\t\t\tActive\n" +
                "1511\t\t25.0104606\t74.1136212\t\t\tActive\n" +
                "1510\t\t25.1459433\t74.21416\t\t\tActive\n" +
                "1509\t\t25.2099682\t74.3485206\t\t\tActive\n" +
                "1508\t\t25.8607349\t74.6184371\t\t\tActive\n" +
                "1507\t\t25.8104144\t74.6158066\t\t\tActive\n" +
                "1506\t\t26.1760411\t74.7086183\t\t\tActive\n" +
                "1505\t\t21.1037897\t86.5323143\t\t\tActive\n" +
                "1504\t\t26.4489401\t74.7895836\t\t\tActive\n" +
                "1503\t\t26.6579393\t75.1724077\t\t\tActive\n" +
                "1502\t\t26.6574689\t75.1722011\t\t\tActive\n" +
                "1501\t\t24.7692633\t84.3483631\t\t\tActive\n" +
                "1500\t\t26.6887065\t88.390908\t\t\tActive\n" +
                "1499\t\t27.2910353\t77.7921485\t\t\tActive\n" +
                "1498\t\t12.821392\t 77.78577\t\t\tActive\n" +
                "1497\t\t17.6564131\t82.9300033\t\t\tActive\n" +
                "1496\t\t21.4199405\t83.87957\t\t\tActive\n" +
                "1495\t\t18.5011384\t73.9337663\t\t\tActive\n" +
                "1494\t\t19.8749989\t78.5659736\t\t\tActive\n" +
                "1493\t\t14.1135483\t79.87495\t\t\tActive\n" +
                "1492\t\t22.5550886\t88.1585428\t\t\tActive\n" +
                "1491\t\t16.4249935\t80.5745096\t\t\tActive\n" +
                "1490\t\t26.1932163\t85.3159418\t\t\tActive\n" +
                "1489\t\t26.9276549\t81.2265091\t\t\tActive\n" +
                "1488\t\t26.622586\t 81.3542796\t\t\tActive\n" +
                "1487\t\t20.5536549\t78.8501307\t\t\tActive\n" +
                "1486\t\t26.7673022\t82.175817\t\t\tActive\n" +
                "1485\t\t26.7957617\t77.9119717\t\t\tActive\n" +
                "1484\t\t30.2495947\t76.8543088\t\t\tActive\n" +
                "1483\t\t27.1651252\t77.8145571\t\t\tActive\n" +
                "1482\t\t21.0488683\t79.0506863\t\t\tActive\n" +
                "1481\t\t28.254776\t 76.82144\t\t\tActive\n" +
                "1480\t\t20.8581078\t78.9644226\t\t\tActive\n" +
                "1479\t\t22.2492424\t73.2168498\t\t\tActive\n" +
                "1478\t\t22.9329892\t79.19176\t\t\tActive\n" +
                "1477\t\t21.236053\t 81.4749\t\t\t    Active\n" +
                "1476\t\t26.3115463\t89.75671\t\t\tActive\n" +
                "1475\t\t22.6287167\t79.222323\t\t\tActive\n" +
                "1474\t\t25.88674\t  78.3341114\t\t\tActive\n" +
                "1473\t\t25.458818\t 78.4828827\t\t\tActive\n" +
                "1472\t\t25.4017138\t81.8268077\t\t\tActive\n" +
                "1471\t\t19.670446\t 73.042929\t\t\tActive\n" +
                "1470\t\t25.7354428\t73.3246805\t\t\tActive\n" +
                "1469\t\t24.9028449\t71.7421832\t\t\tActive\n" +
                "1468\t\t25.031113\t 72.940018\t\t\tActive\n" +
                "1467\t\t27.123911\t 93.86293\t\t\tActive\n" +
                "1465\t\t26.478254\t 90.96743\t\t\tActive\n" +
                "1464\t\t26.092251\t 91.550758\t\t\tActive\n" +
                "1463\t\t26.983392\t 77.9516556\t\t\tActive\n" +
                "1462\t\t22.6372161\t75.8679284\t\t\tActive\n" +
                "1461\t\t22.7074394\t70.4688568\t\t\tActive\n" +
                "1460\t\t23.0535301\t70.7272956\t\t\tActive\n" +
                "1459\t\t23.3074336\t70.493879\t\t\tActive\n" +
                "1458\t\t23.4312193\t70.8986478\t\t\tActive\n" +
                "1457\t\t23.7151309\t71.1003416\t\t\tActive\n" +
                "1456\t\t23.7583247\t71.1616642\t\t\tActive\n" +
                "1455\t\t23.7986951\t71.4896382\t\t\tActive\n" +
                "1454\t\t23.9325912\t71.7946183\t\t\tActive\n" +
                "1453\t\t24.1257295\t71.9545782\t\t\tActive\n" +
                "1452\t\t24.1232822\t71.9527761\t\t\tActive\n" +
                "1451\t\t24.4151119\t72.1545721\t\t\tActive\n" +
                "1450\t\t24.6100811\t72.5112717\t\t\tActive\n" +
                "1449\t\t24.5948081\t72.4566089\t\t\tActive\n" +
                "1448\t\t24.8582361\t72.8236823\t\t\tActive\n" +
                "1447\t\t24.8121469\t72.7790835\t\t\tActive\n" +
                "1446\t\t25.0425169\t72.9538083\t\t\tActive\n" +
                "1445\t\t25.1440706\t73.034395\t\t\tActive\n" +
                "1444\t\t25.5585674\t73.279397\t\t\tActive\n" +
                "1443\t\t25.6874722\t73.317932\t\t\tActive\n" +
                "1442\t\t25.8266766\t73.4498856\t\t\tActive\n" +
                "1441\t\t25.9055722\t73.6425161\t\t\tActive\n" +
                "1440\t\t25.9100522\t73.6553609\t\t\tActive\n" +
                "1439\t\t25.9933594\t73.8296368\t\t\tActive\n" +
                "1438\t\t25.9979447\t73.8377635\t\t\tActive\n" +
                "1437\t\t26.0600581\t74.048845\t\t\tActive\n" +
                "1436\t\t26.0667765\t74.0683369\t\t\tActive\n" +
                "1435\t\t26.0715022\t74.163832\t\t\tActive\n" +
                "1434\t\t19.0846201\t72.8866663\t\t\tActive\n" +
                "1433\t\t28.3856993\t76.934887\t\t\tActive\n" +
                "1432\t\t26.8761527\t75.7123742\t\t\tActive\n" +
                "1431\t\t26.8732571\t75.7209793\t\t\tActive\n" +
                "1430\t\t24.5923929\t74.5278258\t\t\tActive\n" +
                "1429\t\t24.8344027\t74.5941756\t\t\tActive\n" +
                "1428\t\t22.9439581\t74.1982873\t\t\tActive\n" +
                "1427\t\t23.2633392\t74.262379\t\t\tActive\n" +
                "1426\t\t23.27500877\t74.2776666\t\t\tActive\n" +
                "1425\t\t23.3558812\t74.3132018\t\t\tActive\n" +
                "1424\t\t23.5033582\t74.3653433\t\t\tActive\n" +
                "1423\t\t23.8546358\t74.6575123\t\t\tActive\n" +
                "1422\t\t23.7526479\t74.4007756\t\t\tActive\n" +
                "1421\t\t24.6611665\t74.6716207\t\t\tActive\n" +
                "1420\t\t24.0113539\t74.7733231\t\t\tActive\n" +
                "1419\t\t24.4065496\t74.7079543\t\t\tActive\n" +
                "1418\t\t25.3285144\t74.5662093\t\t\tActive\n" +
                "1417\t\t17.741653\t 74.005768\t\t\tActive\n" +
                "1416\t\t26.2613779\t80.4943334\t\t\tActive\n" +
                "1414\t\t24.2483231\t74.7152036\t\t\tActive\n" +
                "1413\t\t24.5807893\t74.6724063\t\t\tActive\n" +
                "1412\t\t23.8298954\t75.1036777\t\t\tActive\n" +
                "1410\t\t22.6002102\t75.1040411\t\t\tActive\n" +
                "1409\t\t22.6664458\t74.9384828\t\t\tActive\n" +
                "1408\t\t22.6987698\t75.4375272\t\t\tActive\n" +
                "1407\t\t22.888901\t75.24739\t\t\tActive\n" +
                "1406\t\t23.1146125\t75.2031022\t\t\tActive\n" +
                "1405\t\t23.3021638\t75.0715076\t\t\tActive\n" +
                "1404\t\t25.0903601\t75.6377041\t\t\tActive\n" +
                "1403\t\t25.1018668\t75.5139316\t\t\tActive\n" +
                "1402\t\t24.6881176\t74.6516192\t\t\tActive\n" +
                "1400\t\t24.8746598\t74.6720663\t\t\tActive\n" +
                "1399\t\t25.0941242\t75.1770317\t\t\tActive\n" +
                "1398\t\t24.3406832\t74.9573082\t\t\tActive\n" +
                "1397\t\t24.263544\t74.9968801\t\t\tActive\n" +
                "1396\t\t24.1607759\t75.0169692\t\t\tActive\n" +
                "1395\t\t24.0181638\t75.0834303\t\t\tActive\n" +
                "1394\t\t23.6647247\t75.1215646\t\t\tActive\n" +
                "1393\t\t23.421353\t75.0667413\t\t\tActive\n" +
                "1392\t\t24.9070049\t76.4474935\t\t\tActive\n" +
                "1391\t\t24.9237931\t76.2942717\t\t\tActive\n" +
                "1390\t\t24.6737596\t76.8534449\t\t\tActive\n" +
                "1389\t\t24.8791\t    76.6651327\t\t\tActive\n" +
                "1388\t\t24.8173151\t76.5257071\t\t\tActive\n" +
                "1387\t\t25.0911167\t76.5341436\t\t\tActive\n" +
                "1386\t\t24.7939179\t76.7195349\t\t\tActive\n" +
                "1385\t\t25.1688524\t76.0999802\t\t\tActive\n" +
                "1384\t\t25.1689999\t76.0998223\t\t\tActive\n" +
                "1382\t\t25.1498714\t76.2623011\t\t\tActive\n" +
                "1381\t\t25.1472322\t75.32321241\t\t\tActive\n" +
                "1379\t\t24.4947803\t74.8953371\t\t\tActive\n" +
                "1377\t\t25.1063866\t74.8965414\t\t\tActive\n" +
                "1372\t\t24.9786208\t74.7220107\t\t\tActive\n" +
                "1369\t\t24.409149\t74.914742\t\t\tActive\n" +
                "1368\t\t24.571562\t74.762482\t\t\tActive\n" +
                "1365\t\t17.8642104\t78.4650263\t\t\tActive\n" +
                "1363\t\t13.070931\t77.442184\t\t\tActive\n" +
                "1362\t\t21.4778288\t78.9011666\t\t\tActive\n" +
                "1360\t\t28.29361\t76.864204\t\t\tActive\n" +
                "1359\t\t18.6679394\t73.7278731\t\t\tActive\n" +
                "1358\t\t27.1950264\t75.894722\t\t\tActive\n" +
                "1357\t\t14.217111\t76.417759\t\t\tActive\n" +
                "1356\t\t13.9194299\t76.651681\t\t\tActive\n" +
                "1353\t\t25.1147199\t74.10326\t\t\tActive\n" +
                "1352\t\t18.911098\t72.984707\t\t\tActive\n" +
                "1351\t\t19.783332\t72.783453\t\t\tActive\n" +
                "1350\t\t18.821853\t73.0927971\t\t\tActive\n" +
                "1349\t\t18.7160347\t73.0592051\t\t\tActive\n" +
                "1348\t\t18.93508\t73.13106\t\t\tActive\n" +
                "1347\t\t18.961352\t73.146393\t\t\tActive\n" +
                "1346\t\t18.889803\t73.2623382\t\t\tActive\n" +
                "1345\t\t19.4904246\t72.9064959\t\t\tActive\n" +
                "1344\t\t19.7757427\t72.9132493\t\t\tActive\n" +
                "1343\t\t18.8059087\t73.3202085\t\t\tActive\n" +
                "1342\t\t19.531407\t72.916417\t\t\tActive\n" +
                "1338\t\t26.8584516\t75.662417\t\t\tActive\n" +
                "1333\t\t21.5051333\t78.8504161\t\t\tActive\n" +
                "1331\t\t16.529004\t74.322544\t\t\tActive\n" +
                "1328\t\t21.298561\t74.868075\t\t\tActive\n" +
                "1327\t\t22.7900741\t75.9365994\t\t\tActive\n" +
                "1326\t\t21.3309075\t74.9045411\t\t\tActive\n" +
                "1325\t\t22.0297214\t75.3520941\t\t\tActive\n" +
                "1324\t\t21.216355\t74.833071\t\t\tActive\n" +
                "1323\t\t21.000241\t74.78404\t\t\tActive\n" +
                "1322\t\t20.6449819\t74.6626585\t\t\tActive\n" +
                "1321\t\t20.5670398\t74.5637198\t\t\tActive\n" +
                "1320\t\t20.4519763\t74.3937013\t\t\tActive\n" +
                "1319\t\t20.148693\t73.98059\t\t\tActive\n" +
                "1318\t\t19.917736\t73.7129701\t\t\tActive\n" +
                "1317\t\t19.6284223\t73.4529802\t\t\tActive\n" +
                "1309\t\t23.1503341\t76.1508657\t\t\tActive\n" +
                "1308\t\t22.9386561\t76.0601604\t\t\tActive\n" +
                "1307\t\t22.511374\t75.661202\t\t\tActive\n" +
                "1306\t\t21.484102\t75.002499\t\t\tActive\n" +
                "1305\t\t24.293415\t77.077153\t\t\tActive\n" +
                "1304\t\t23.9352153\t76.915241\t\t\tActive\n" +
                "1303\t\t23.461362\t76.341943\t\t\tActive\n" +
                "1302\t\t23.899463\t76.888587\t\t\tActive\n" +
                "1300\t\t21.6999268\t75.1149336\t\t\tActive\n" +
                "1299\t\t22.251032\t75.474482\t\t\tActive\n" +
                "1298\t\t24.8973566\t77.508033\t\t\tActive\n" +
                "1297\t\t24.737666\t77.366489\t\t\tActive\n" +
                "1296\t\t24.466363\t77.1715941\t\t\tActive\n" +
                "1295\t\t24.034674\t76.951707\t\t\tActive\n" +
                "1294\t\t23.8055312\t76.8130451\t\t\tActive\n" +
                "1293\t\t23.6154339\t76.5468761\t\t\tActive\n" +
                "1292\t\t23.3221828\t76.1697897\t\t\tActive\n" +
                "1291\t\t22.9017662\t75.9764564\t\t\tActive\n" +
                "1290\t\t22.59882\t75.708055\t\t\tActive\n" +
                "1289\t\t22.393231\t75.539089\t\t\tActive\n" +
                "1288\t\t21.963072\t75.288546\t\t\tActive\n" +
                "1287\t\t21.8644249\t75.202788\t\t\tActive\n" +
                "1286\t\t21.53532\t75.048916\t\t\tActive\n" +
                "1285\t\t21.398551\t74.964035\t\t\tActive\n" +
                "1284\t\t20.879847\t74.7884524\t\t\tActive\n" +
                "1283\t\t20.389355\t74.3284616\t\t\tActive\n" +
                "1282\t\t20.2390467\t74.0698423\t\t\tActive\n" +
                "1281\t\t20.0442432\t73.8736635\t\t\tActive\n" +
                "1280\t\t19.74218\t73.640194\t\t\tActive\n" +
                "1279\t\t19.695681\t73.594271\t\t\tActive\n" +
                "1278\t\t19.695468\t73.537142\t\t\tActive\n" +
                "1277\t\t19.539264\t73.347374\t\t\tActive\n" +
                "1276\t\t19.3790917\t73.2106671\t\t\tActive\n" +
                "1275\t\t208998470\t74.7884524\t\t\tActive\n" +
                "1274\t\t22.640606\t75.877529\t\t\tActive\n" +
                "1271\t\t18.4885742\t74.0656011\t\t\tActive\n" +
                "1270\t\t18.4878463\t74.1020412\t\t\tActive\n" +
                "1269\t\t18.4348683\t74.450019\t\t\tActive\n" +
                "1268\t\t18.4891306\t74.0364404\t\t\tActive\n" +
                "1267\t\t18.42988\t74.461585\t\t\tActive\n" +
                "1263\t\t13.06183\t80.1467312\t\t\tActive\n" +
                "1262\t\t13.055443\t80.092216\t\t\tActive\n" +
                "1261\t\t12.8740219\t79.6955357\t\t\tActive\n" +
                "1260\t\t12.8983003\t79.5534433\t\t\tActive\n" +
                "1259\t\t12.8978814\t79.4946805\t\t\tActive\n" +
                "1258\t\t12.9470442\t79.223539\t\t\tActive\n" +
                "1256\t\t12.8905543\t78.9098486\t\t\tActive\n" +
                "1255\t\t12.6439876\t78.5799422\t\t\tActive\n" +
                "1254\t\t12.5532453\t78.4534476\t\t\tActive\n" +
                "1253\t\t12.5435896\t78.3110773\t\t\tActive\n" +
                "1252\t\t12.5422252\t78.2028032\t\t\tActive\n" +
                "1251\t\t12.5679821\t78.1748036\t\t\tActive\n" +
                "1247\t\t13.1560045\t77.328344\t\t\tActive\n" +
                "1246\t\t13.2508448\t77.22117\t\t\tActive\n" +
                "1245\t\t13.304548\t77.158638\t\t\tActive\n" +
                "1244\t\t13.3032653\t77.1604582\t\t\tActive\n" +
                "1242\t\t13.7634443\t76.8637259\t\t\tActive\n" +
                "1241\t\t13.9291111\t76.6299206\t\t\tActive\n" +
                "1240\t\t14.0310219\t76.5768786\t\t\tActive\n" +
                "1239\t\t14.245841\t76.367501\t\t\tActive\n" +
                "1238\t\t14.6542202\t75.5691425\t\t\tActive\n" +
                "1237\t\t14.6946102\t75.5295819\t\t\tActive\n" +
                "1234\t\t15.1289085\t75.148606\t\t\tActive\n" +
                "1233\t\t15.3314731\t75.10133\t\t\tActive\n" +
                "1231\t\t15.5544986\t74.8248912\t\t\tActive\n" +
                "1230\t\t15.7774141\t74.6354173\t\t\tActive\n" +
                "1228\t\t16.0515932\t74.513582\t\t\tActive\n" +
                "1227\t\t16.142589\t74.517092\t\t\tActive\n" +
                "1226\t\t16.2733915\t74.4576639\t\t\tActive\n" +
                "1225\t\t16.3435845\t74.4029821\t\t\tActive\n" +
                "1224\t\t23.5789917\t73.312797\t\t\tActive\n" +
                "1223\t\t23.423423\t73.382274\t\t\tActive\n" +
                "1222\t\t23.011501\t73.61919116\t\t\tActive\n" +
                "1221\t\t22.811243\t73.646837\t\t\tActive\n" +
                "1220\t\t22.729664\t73.590602\t\t\tActive\n" +
                "1219\t\t22.505948\t73.457778\t\t\tActive\n" +
                "1216\t\t16.6183804\t74.2989751\t\t\tActive\n" +
                "1215\t\t16.8338138\t74.289127\t\t\tActive\n" +
                "1214\t\t16.8789908\t74.297532\t\t\tActive\n" +
                "1213\t\t17.0865731\t74.2194878\t\t\tActive\n" +
                "1212\t\t17.2874408\t74.1697536\t\t\tActive\n" +
                "1211\t\t17.7671432\t73.9894683\t\t\tActive\n" +
                "1210\t\t17.9230426\t73.9746906\t\t\tActive\n" +
                "1209\t\t18.0328095\t74.021286\t\t\tActive\n" +
                "1208\t\t18.3567168\t73.8535715\t\t\tActive\n" +
                "1207\t\t18.3686364\t73.8540636\t\t\tActive\n" +
                "1206\t\t18.7241021\t74.0214553\t\t\tActive\n" +
                "1205\t\t18.6974995\t73.7051544\t\t\tActive\n" +
                "1204\t\t18.7902615\t73.3008845\t\t\tActive\n" +
                "1203\t\t19.3430292\t72.8913943\t\t\tActive\n" +
                "1202\t\t19.3164982\t72.9454834\t\t\tActive\n" +
                "1201\t\t19.2432411\t73.0453478\t\t\tActive\n" +
                "1197\t\t26.2724958\t74.2023455\t\t\tActive\n" +
                "1194\t\t21.073966\t72.979811\t\t\tActive\n" +
                "1193\t\t22.005526\t73.112044\t\t\tActive\n" +
                "1192\t\t22.719397\t72.701856\t\t\tActive\n" +
                "1190\t\t28.389885\t76.696648\t\t\tActive\n" +
                "1188\t\t21.041311\t72.976072\t\t\tActive\n" +
                "1186\t\t26.32244\t74.155333\t\t\tActive\n" +
                "1185\t\t26.2562567\t74.4910732\t\t\tActive\n" +
                "1184\t\t26.429886\t74.6861995\t\t\tActive\n" +
                "1183\t\t26.5645227\t74.8018554\t\t\tActive\n" +
                "1181\t\t28.120729\t77.331207\t\t\tActive\n" +
                "1180\t\t26.8733696\t75.7220992\t\t\tActive\n" +
                "1179\t\t22.4005467\t87.686479\t\t\tActive\n" +
                "1178\t\t22.0642142\t88.0814152\t\t\tActive\n" +
                "1177\t\t22.1904933\t87.9162917\t\t\tActive\n" +
                "1176\t\t22.4323942\t87.8671748\t\t\tActive\n" +
                "1175\t\t22.4340041\t87.8643383\t\t\tActive\n" +
                "1174\t\t22.4707103\t87.9850093\t\t\tActive\n" +
                "1173\t\t22.619761\t88.28666\t\t\tActive\n" +
                "1172\t\t23.2692915\t87.8217714\t\t\tActive\n" +
                "1171\t\t23.2692915\t87.8217714\t\t\tActive\n" +
                "1170\t\t23.47276\t87.411037\t\t\tActive\n" +
                "1169\t\t23.7687165\t86.8339367\t\t\tActive\n" +
                "1168\t\t23.7619947\t86.7941447\t\t\tActive\n" +
                "1167\t\t23.8784975\t86.3136279\t\t\tActive\n" +
                "1166\t\t23.8152325\t86.5617309\t\t\tActive\n" +
                "1165\t\t22.682803\t75.95605\t\t\tActive\n" +
                "1164\t\t23.9916058\t86.010891\t\t\tActive\n" +
                "1163\t\t24.4107693\t85.2392745\t\t\tActive\n" +
                "1162\t\t24.916891\t84.111736\t\t\tActive\n" +
                "1161\t\t24.704425\t84.474088\t\t\tActive\n" +
                "1160\t\t24.91051\t84.169478\t\t\tActive\n" +
                "1158\t\t25.2416761\t83.4147152\t\t\tActive\n" +
                "1157\t\t25.2464293\t83.3885502\t\t\tActive\n" +
                "1156\t\t22.291574\t73.252996\t\t\tActive\n" +
                "1153\t\t25.2491807\t82.947235\t\t\tActive\n" +
                "1152\t\t25.2647998\t82.9020267\t\t\tActive\n" +
                "1151\t\t25.5913565\t81.8620622\t\t\tActive\n" +
                "1150\t\t25.5756865\t81.5283045\t\t\tActive\n" +
                "1149\t\t25.6488308\t81.3599905\t\t\tActive\n" +
                "1142\t\t26.5053174\t80.4626977\t\t\tActive\n" +
                "1141\t\t26.483607\t80.453646\t\t\tActive\n" +
                "1139\t\t25.8796436\t80.9289438\t\t\tActive\n" +
                "1138\t\t26.451235\t80.197259\t\t\tActive\n" +
                "1137\t\t26.3863927\t80.0221043\t\t\tActive\n" +
                "1136\t\t27.2318795\t78.1680066\t\t\tActive\n" +
                "1135\t\t25.27758\t77.625557\t\t\tActive\n" +
                "1134\t\t27.8591872\t77.3998558\t\t\tActive\n" +
                "1133\t\t27.8591872\t77.3998558\t\t\tActive\n" +
                "1131\t\t27.3707327\t77.7034453\t\t\tActive\n" +
                "1129\t\t22.4775723\t88.064002\t\t\tActive\n" +
                "1128\t\t26.367342\t78.087044\t\t\tActive\n" +
                "1127\t\t25.948944\t77.804024\t\t\tActive\n" +
                "1126\t\t26.416862\t78.057709\t\t\tActive\n" +
                "1125\t\t26.507795\t77.97297\t\t\tActive\n" +
                "1123\t\t25.08852\t77.595749\t\t\tActive\n" +
                "1119\t\t26.7399121\t74.8955037\t\t\tActive\n" +
                "1117\t\t26.673388\t77.897659\t\t\tActive\n" +
                "1116\t\t27.041521\t77.975197\t\t\tActive\n" +
                "1108\t\t23.641209\t87.110127\t\t\tActive\n" +
                "1102\t\t23.295702\t70.370911\t\t\tActive\n" +
                "1098\t\t27.0723\t    77.955464\t\t\tActive\n" +
                "1095\t\t28.204428\t76.77977\t\t\tActive\n" +
                "1082\t\t26.592529\t74.926399\t\t\tActive\n" +
                "1079\t\t26.99738\t75.7704597\t\t\tActive\n" +
                "1078\t\t27.000164\t75.774231\t\t\tActive\n" +
                "1077\t\t18.7456916\t73.7884092\t\t\tActive\n" +
                "1069\t\t25.641515\t74.59635\t\t\tActive\n" +
                "1056\t\t18.732857\t73.976418\t\t\tActive\n" +
                "1054\t\t25.069805\t74.623451\t\t\tActive\n" +
                "1053\t\t18.806747\t73.872795\t\t\tActive\n" +
                "1050\t\t18.486395\t74.040672\t\t\tActive\n" +
                "1049\t\t18.960299\t73.148003\t\t\tActive\n" +
                "1043\t\t20.311232\t72.901917\t\t\tActive\n" +
                "1040\t\t21.555344\t73.006744\t\t\tActive\n" +
                "1039\t\t22.394215\t73.136009\t\t\tActive\n" +
                "1037\t\t22.347044\t73.241318\t\t\tActive\n" +
                "1035\t\t26.094332\t74.682327\t\t\tActive\n" +
                "1034\t\t26.287424\t74.752785\t\t\tActive\n" +
                "1031\t\t23.111103\t72.674141\t\t\tActive\n" +
                "1029\t\t23.420826\t72.836388\t\t\tActive\n" +
                "1026\t\t24.7185772\t74.3958779\t\t\tActive\n" +
                "1025\t\t24.538351\t73.706856\t\t\tActive\n" +
                "1019\t\t27.183359\t75.8797\t\t\t    Active\n" +
                "1018\t\t27.292418\t75.962219\t\t\tActive\n" +
                "1016\t\t27.26738\t75.949638\t\t\tActive\n" +
                "1014\t\t28.30899\t76.88279\t\t\tActive\n" +
                "1013\t\t26.836101\t75.593116\t\t\tActive\n" +
                "1012\t\t26.723405\t75.293356\t\t\tActive\n" +
                "1011\t\t28.382637\t76.969078\t\t\tActive\n" +
                "1587\t\t22.6747328608654\t\t75.9188311489691\t\tActive\n"+
                "1536\t\t19.3441982269287\t\t73.1233749389648\t\tActive";
    }
    public static String getInactiveString(){
        return "1466\t\t24.601255\t72.59108\t\t\tIn-active\n" +
                "1401\t\t24.7880721\t74.6367869\t\t\tIn-active\n" +
                "1364\t\t28.285076\t76.855697\t\t\tIn-active\n" +
                "1265\t\t18.0463768\t74.015372\t\t\tIn-active\n" +
                "1264\t\t17.8203786\t73.9657626\t\t\tIn-active\n" +
                "1257\t\t12.914581\t79.022746\t\t\tIn-active\n" +
                "1250\t\t12.6807633\t77.9510678\t\t\tIn-active\n" +
                "1249\t\t12.7751444\t77.7792941\t\t\tIn-active\n" +
                "1248\t\t12.8146884\t77.6921565\t\t\tIn-active\n" +
                "1243\t\t13.5775065\t76.9771839\t\t\tIn-active\n" +
                "1236\t\t14.9123384\t75.2769376\t\t\tIn-active\n" +
                "1235\t\t15.040756\t75.172433\t\t\tIn-active\n" +
                "1232\t\t15.543872\t74.839784\t\t\tIn-active\n" +
                "1218\t\t16.543305\t74.3184093\t\t\tIn-active\n" +
                "1217\t\t16.5435603\t74.3184787\t\t\tIn-active\n" +
                "1187\t\t26.6196941\t75.0663185\t\t\tIn-active\n" +
                "1159\t\t25.1924399\t83.55714\t\t\tIn-active\n" +
                "1155\t\t25.263309\t83.2019988\t\t\tIn-active\n" +
                "1148\t\t26.1200864\t80.540739\t\t\tIn-active\n" +
                "1140\t\t25.3650711\t82.1726462\t\t\tIn-active\n" +
                "1132\t\t27.31764\t77.761961\t\t\tIn-active\n" +
                "1130\t\t27.636703\t77.566827\t\t\tIn-active\n" +
                "1124\t\t25.358993\t77.630149\t\t\tIn-active\n" +
                "1122\t\t26.983392\t77.9516556\t\t\tIn-active\n" +
                "1111\t\t26.875029\t75.724525\t\t\tIn-active\n" +
                "1100\t\t26.8595948\t78.9260719\t\t\tIn-active\n" +
                "1075\t\t30.1633158\t77.2891363\t\t\tIn-active\n" +
                "1052\t\t18.748405\t73.62043\t\t\tIn-active\n" +
                "1051\t\t18.460411\t74.342499\t\t\tIn-active\n" +
                "1048\t\t19.106138\t73.066505\t\t\tIn-active\n" +
                "1047\t\t19.376751\t72.895882\t\t\tIn-active\n" +
                "1046\t\t19.369823\t73.187469\t\t\tIn-active\n" +
                "1044\t\t19.336559\t72.892629\t\t\tIn-active\n" +
                "1042\t\t21.037031\t72.973228\t\t\tIn-active\n" +
                "1038\t\t22.393476\t73.1343\t\t\t    In-active\n" +
                "1036\t\t25.535267\t74.588799\t\t\tIn-active\n" +
                "1030\t\t23.262016\t72.748863\t\t\tIn-active\n" +
                "1015\t\t26.833034\t75.582072\t\t\tIn-active";
    }

    //        System.out.println(s1.indexOf("1631")+" "+s1.indexOf("25.071612")+" "+s1.indexOf("75.584455")+" "+s1.indexOf("Active"));
//        String id=s1.substring(0,5).trim();
//        String lat=s1.substring(6,16).trim();
//        String lon=s1.substring(16,27).trim();
//        String isActive=s1.substring(28,34).trim();
//        System.out.println(id+" "+lat+" "+lon+" "+isActive);
}
