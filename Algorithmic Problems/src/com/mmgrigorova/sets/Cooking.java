package com.mmgrigorova.sets;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Cooking
 * http://judge.telerikacademy.com/problem/01cooking
 */

public class Cooking {

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        int recipeLines = in.nextInt();
        in.nextLine();

        Map<String, Ingredient> recipe = new HashMap<>();

        for (int i = 0; i < recipeLines; i++) {
            String input = in.nextLine();
            String key = getKey(input);
            if (recipe.containsKey(key)) {
                Ingredient match = recipe.get(key);
                Ingredient toAdd = createIngredient(input);
                match.addToIngredient(toAdd);
            } else {
                insertIngredientInMap(input, recipe);
            }
        }

        Map<String, Ingredient> usedIngredients = new HashMap<>();
        Map<String, Ingredient> result = new HashMap<>();

        int usedLines = in.nextInt();
        in.nextLine();

        Ingredient used = null;
        Ingredient match = null;
        try {
            for (int i = 0; i < usedLines; i++) {
                String input = in.nextLine();
                String ingredKey = insertIngredientInMap(input, usedIngredients);


                if (recipe.containsKey(ingredKey)) {
                    match = recipe.get(ingredKey);
                    used = usedIngredients.get(ingredKey);
                    used = used.getDifference(match);
                    if ((used.quantity > 0 && used.quantity < match.quantity)) {
                        result.put(ingredKey, used);
                    } else {
                        result.put(ingredKey, null);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(match.ingredientName);
            e.printStackTrace();
        }

        for (String s : recipe.keySet()) {
            if (!result.containsKey(s)) {
                result.put(s, recipe.get(s));
            }
        }

//        for (String s : result.keySet()) {
//            if (result.get(s) != null) {
//                System.out.println(result.get(s));
//            }
//        }


        result.values().stream()
                .filter(Objects::nonNull)
                .sorted()
                .forEach(System.out::println);

    }

    public static String insertIngredientInMap(String input, Map<String, Ingredient> map) {
        String key = getKey(input);
        Ingredient ingredient = createIngredient(input);
        map.put(key, ingredient);
        return key;
    }

    public static Ingredient createIngredient(String input) {
        String[] recipeLine = input.split(":");
        String keyLine = recipeLine[2].toLowerCase();
        double quantity = Double.parseDouble(recipeLine[0]);
        String measurement = recipeLine[1];
        String ingredientName = recipeLine[2];

        Ingredient ingredient = new Ingredient(quantity, measurement, ingredientName);

        return ingredient;
    }

    public static String getKey(String input) {
        String[] recipeLine = input.split(":");
        return recipeLine[2].toLowerCase();
    }



    private static class Ingredient implements Comparable<Ingredient> {
        private static int INGREDIENT_ID = 0;
        private static HashMap<String, Integer> measureMap;
        private static HashMap<String, String> measureLegend;

        static {
            measureMap = new HashMap<>();
            measureLegend = new HashMap<>();
            measureMap.put("tsps", 5);
            measureMap.put("tbsps", 15);
            measureMap.put("ls", 1000);
            measureMap.put("cups", 240);
            measureMap.put("fl ozs", 240);
            measureMap.put("gals", 3840);
            measureMap.put("pts", 480);
            measureMap.put("qts", 960);
            measureMap.put("mls", 1);
            measureLegend.put("teaspoons", "tsps");
            measureLegend.put("tablespoons", "tbsps");
            measureLegend.put("liters", "ls");
            measureLegend.put("cups", "cups");
            measureLegend.put("fluid ounces", "fl ozs");
            measureLegend.put("gallons", "gals");
            measureLegend.put("pints", "pts");
            measureLegend.put("quarts", "qts");
            measureLegend.put("milliliters", "mls");
        }

        private double quantity;
        private String measurement;
        private String ingredientName;

        public Ingredient(double quantity, String measurement, String ingredientName) {
            INGREDIENT_ID += 1;
            this.quantity = quantity;
            this.measurement = measurement;
            this.ingredientName = ingredientName;
        }

        @Override
        public String toString() {
            return String.format("%.2f:%s:%s", quantity, measurement, ingredientName);
//            return String.format("%f:%s:%s", quantity, measurement, ingredientName);
        }

        public Ingredient getDifference(Ingredient matchTo) {
            double from = quantity;
            double target = convert(matchTo.quantity, getMeasurement(), matchTo.getMeasurement());

            double value = target - from;

            value = convert(value, matchTo.getMeasurement(), getMeasurement());

            Ingredient converted = new Ingredient(value, matchTo.getMeasurement(), matchTo.ingredientName);

            return converted;
        }

        public void addToIngredient(Ingredient toAdd) {
            double addition = convert(toAdd.quantity, getMeasurement(), toAdd.getMeasurement());
            quantity += addition;
        }

        private String getMeasurement() {
            if (measureMap.keySet().contains(measurement)) {
                return measurement;
            } else if (measureLegend.containsKey(measurement)) {
                return measureLegend.get(measurement);
            }
            return null;
        }

        private double convert(double quantity, String measurementFrom, String measurementTo) {
            int factorFrom = measureMap.get(measurementFrom);
            int factorTo = measureMap.get(measurementTo);

            double result = quantity * factorTo / factorFrom;
            return result;

        }

        public int getIngredientId() {
            return INGREDIENT_ID;
        }

        @Override
        public int compareTo(Ingredient compareIngredient) {
            int compareID = compareIngredient.getIngredientId();
            return compareID - this.getIngredientId();
        }
    }

    static void fakeInput() {
//        String test = "2\n" +
//                "12:ls:water\n" +
//                "12000:mls:Water\n" +
//                "1\n" +
//                "12:cups:coffee";
//        String test = "2\n" +
//                "1:cups:Sugar\n" +
//                "1.006:ls:Old milK\n" +
//                "2\n" +
//                "800:mls:old MILK\n" +
//                "1.5:cups:sugar";

        String test = "20\n" +
                "36071.1:fluid ounces:XDZbIPiYASf\n" +
                "116196.9:tbsps:lpSNoHDXlJofrynf\n" +
                "42967.6:tsps:GpQlkYDmtpNUydCtIBuUkGB\n" +
                "16057:cups:dqApQwlD\n" +
                "51509.2:qts:iahyNtXqWwizdIMwLlGnQFJtlgLjOlDCLQRNALuQuACRp\n" +
                "6419.1:cups:ZUuq ByaoygQzjNvEP yBKsiLFw\n" +
                "16809:quarts:Y HYn\n" +
                "118277.4:fl ozs:mipegrrTVaYXlfpZKtjVfYL ZAxgRbVUv\n" +
                "34002.1:tsps:oyDCmvsewAZAcwNIBtsTuz TxiBXLcyNK LWGPVz\n" +
                "3003.7:milliliters:ettrVjQKOBnQtWvjMHJyq\n" +
                "75938.6:quarts:BjaZSPsnj\n" +
                "25675.4:liters:kPjTLnefmajTC\n" +
                "48095.3:liters:lvV\n" +
                "3462.4:teaspoons:wCCNimdsbaGjQXMdMADSDQMwwZbbZBNaTitQnc\n" +
                "81679.1:tablespoons:WG KFkFrlMYpxsXrgQUVNqRoUrBw tFBrirTAJpA\n" +
                "1146.3:pts:ZkXwJQRCEeZsUgbLOsvWNHkju\n" +
                "78473.4:pts:WOAjIExldAXiru\n" +
                "92439.8:mls:yhgJXior\n" +
                "121380.3:liters:RYTmOLHqcJcURO\n" +
                "109630.5:tbsps:zLdyEdUkQKaovVYvKyxlSWeTdVqCBOvpCJmWSeDW\n" +
                "1000\n" +
                "117694.1:quarts:mODaYcDBtCrHWciHLXHzl txo\n" +
                "33446:fl ozs:BaijMisrQJTIF OTZCXgAHWyz\n" +
                "50294.7:pts:SZThPeMLEXEKIktmEXnRBYgPTxfeIvjsrFNRboSJsZ\n" +
                "78559.3:fluid ounces:cWFMOgTnYGQDDCuzHHLDucKhWmiwAmXdtrOlubdlaAHaN\n" +
                "72919.2:cups:jgLhuNmBCAykkfRxKjwVtoMwnYZvKJ\n" +
                "61977.2:tablespoons:L wiSQRCEGGGVmmdKSrVynSjelfoZCrAvvQRIvasfIgcud\n" +
                "66139.5:mls:aABSfybl\n" +
                "72056.7:tbsps:A xBuNvFAbvCFs\n" +
                "46928.5:pints:tj\n" +
                "2989.6:pts:vUpihRafUKOlALPkEJnvZyrbkIuMywzLnqPLKeUFXb\n" +
                "37606.8:teaspoons:xxXyhhhvxcGUSWVuhiENqvOy YFgklPRYeMYSjUeHm\n" +
                "56693.8:gals:eAbSBxzDmwAOmIexSPdeIqANtTEGuaWBm\n" +
                "61418.7:cups:nEogSarDzEITQhGnedqPBzmzYZIdBsEevgeUjRyQJClZ\n" +
                "124967.5:tablespoons:etoawZZWvudAoAiAtkoaHmHDiigsujbByVoENZqTKdU\n" +
                "26377.9:pints:lpIUDbgHlmcKJjxHgrKMnXBqOalNJeJPpRCeCwRnhECDSe\n" +
                "48894.7:qts:oBYCuUlEAgehYHGCfvdKPp yPnFJGHUQmKFBR W\n" +
                "47385:pts:TzHrLOdtLNfiTUabs\n" +
                "91335.7:tablespoons:DNiOHkWC\n" +
                "78976.8:liters:lLYUTYViPQHwypOsCxjkYMbptdEnLPCDjERzXhYqVCPPASSf\n" +
                "115546.3:gals:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "2703.9:pts:eky\n" +
                "40963.8:cups:YBIoGcPOBdkdXHLtwyHZOcQqFOGAYYnsZKwtDTUlVOm\n" +
                "8729.9:teaspoons:Yw BlDDJhJrbHAyrljJquEMkFXqiI\n" +
                "7246.4:tablespoons:hEjCwbrBJ\n" +
                "40716.4:gals:lsXiqwCmWulZWUG\n" +
                "59243.8:pts:YVkAqpUVPDfEewhsOXoAzgTTSYysMraNca\n" +
                "100670.6:liters:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "124289.8:quarts:IqNwrMCFAOfWufzDeSOYxD a hciLlkXGvqfDhPSBXNvStuBH\n" +
                "14250.7:quarts:knsjkpt MEHBDEHDKilDcoODUlhcGIvEzpYcNJpD Sssf\n" +
                "61025:teaspoons:urZOXeUhfnVXKTiYN\n" +
                "3185.1:quarts:zPGWU\n" +
                "44240.7:fluid ounces:UYkPfYyX\n" +
                "80196.8:tsps:ArWHWUQQT\n" +
                "81951.6:pts:xXliKpyjJxkmIORIFXpRarYERPAboTapoEIWYGkRMdNrsiaS\n" +
                "83535:tablespoons:pWolPwBI\n" +
                "17830:fluid ounces:pWolPwBI\n" +
                "92334.7:qts:fWPshEem SeWgxBuhvVAzrhOVXACZVYMJZ\n" +
                "65817.5:cups:CJFIGOgFAfmaCUMfFpCQJkQB\n" +
                "117641.3:gals:epboPTpMMnPiQeYvgpgagj\n" +
                "26646.9:quarts:Ltwbxuya RFLEnYOduT EjbaxUS\n" +
                "124885.4:quarts:pu\n" +
                "37447.7:mls:VF\n" +
                "51649.6:ls:nJPoQKCMRggEkJspOlDqDc\n" +
                "53457.9:fl ozs:ISgcPqBkCFplwVQKluJpInyotUgoBkbcO\n" +
                "90654.7:fluid ounces:MfXK OEMpLRogWNjybHKdPZxLDBwbaqT IIUrJxpdUgjb\n" +
                "85683.1:pts:qvrPUFfyIUKXUzcIubiDDWb hgmIbhFcMAuUkjzVgOXX\n" +
                "36047.3:mls:E\n" +
                "42654.5:teaspoons:rHHR\n" +
                "90172.1:pts:zWJtgcHZkLSRF\n" +
                "73231.8:ls:TOGUctXOZIZKewpU\n" +
                "61845.8:cups:UTjMD HYqralzBKibX\n" +
                "114279.9:pts:eVmlUqDAYOfnDzPxDhfazCIVtutPHfCGDXTDYOKrjmgj\n" +
                "89786.5:quarts:fNXOtqixaVMJNPsqbagwpplXMhzQP\n" +
                "4158.7:milliliters:sykhaFqZCaLeHKkyvCJcavH sdR BxuryAhsWGefk\n" +
                "33410.9:ls:O fVBWuDASueOwWzAV\n" +
                "64693.8:mls:lalgkwojgvnqYUEXRKNKqygQaPqUO\n" +
                "30614.9:cups:LuqS\n" +
                "51234.8:pts:gPzHTypquKnxX\n" +
                "74029.8:milliliters:weCD\n" +
                "80524.7:gallons:BablQrG IYgNRqLzHDfHsjOewAjrpLvgLi DAhLZ\n" +
                "123689.2:fl ozs:RRJnQRYZapSSbyHVcG hofOqlYCZUWqSzgqVUb ohFpswdCF\n" +
                "75058.5:fl ozs:rINwDGFTVKvDVlPrztkUiDfGmjE\n" +
                "101564:liters:FnGybsvpzDjWJwsLZK V aEORkrtwlCJcGCjgVSDBRCLchu\n" +
                "115408.9:fluid ounces:mVIPM\n" +
                "4388.6:cups:WlShfNOmwXrlvYQRbwzflHuyPHTJ\n" +
                "91508:milliliters:gPzHTypquKnxX\n" +
                "42297.7:ls:eOtVwkJKSTvAFfrcWoNxSVYYqJhCyFTqAnv\n" +
                "59840:pts:UaRHbmPX\n" +
                "31190.6:teaspoons:GyfohBhqaOyiU\n" +
                "53408.3:fluid ounces:b\n" +
                "113445.3:cups:qgXZNAWNOLZBcrwaRIBYTeKKESvdFUygXHzMbDjFDTh\n" +
                "94383.5:qts:eOtVwkJKSTvAFfrcWoNxSVYYqJhCyFTqAnv\n" +
                "109267.3:gals:BQC KacHM GipStTy l\n" +
                "115189:liters:mrAuTFnDaaaXKlEgCppcwMgmVupTwOR\n" +
                "59503.9:cups:NYzWxKzkYezsYYqukajMxFDtONtl\n" +
                "92991.6:milliliters:qgXZNAWNOLZBcrwaRIBYTeKKESvdFUygXHzMbDjFDTh\n" +
                "52.3:pts:wEkdFcJ\n" +
                "49201.3:fl ozs:oyDCmvsewAZAcwNIBtsTuz TxiBXLcyNK LWGPVz\n" +
                "104489.1:liters:PDvfgSsTkBYKdVNQUnSIYdwQqPL\n" +
                "50235.3:fluid ounces:nreHbfbyITcPgvYNhDaOH\n" +
                "112546.7:gallons:ByUaESstMGOapfAgOpWbphJtTlSKQ\n" +
                "61817.5:fluid ounces:XvcxdrNxF\n" +
                "20855.8:gals:ADgL MfwlTndherIVioLmhfJ\n" +
                "42477.8:tsps:SQjHQrwK\n" +
                "7548.7:liters:jbGbkSWsviSU mbYvFrfqNICEJT\n" +
                "88416.8:fluid ounces:qFxMwtLCcSxSgVxn dDZb\n" +
                "108579.3:tablespoons:IiwZAQLcEIhzecVaxUHbQqGhJMIrBeeTkUsyjVXk\n" +
                "104239.2:quarts:jCOnnupUYyrswIO\n" +
                "51848:ls:SKwgpsM\n" +
                "52014.5:qts:e\n" +
                "51961.6:fl ozs:aluSYRfhqmSzBNtqUgRnuz\n" +
                "66263.5:mls:WCEUScFDBkMOn\n" +
                "62663.1:mls:SWjhproZW\n" +
                "49426.9:mls:OnJeqCMcQS x ZBaMlmxSlY gaOeVVGZtdaTJYPVKpFxLad\n" +
                "57292:tbsps:kuRXeiMEprggFpHoWDeTFoeZz\n" +
                "22096.2:tablespoons:kBXgrMLSPsGxtmWOqiq\n" +
                "109448.8:gals:wmykm ITjNYAzgX\n" +
                "58389.9:fluid ounces:OVnZKmrbbYGvLrTdItlxAjCTDybDgAGbdYFL\n" +
                "17236.6:gallons:sXRbRzspDrZoMKhHXCZaCcaWoIAudYo\n" +
                "3396.6:cups:FNvmUTTKlgzHSbcZRqlXGJZLfCKtkmRPS\n" +
                "15600.1:fluid ounces:zLvhAnqDIWcPWIiGqRFBOfaaE\n" +
                "84799:liters:rvaZWKXYaHllWmGuhNVREPZj\n" +
                "11406.8:liters:lpSNoHDXlJofrynf\n" +
                "22374.4:liters:VseNJyZrxFknZOvTnVSlRcrHrQBiyDsBeDlaJjDdzP\n" +
                "89168.6:tablespoons:cWFMOgTnYGQDDCuzHHLDucKhWmiwAmXdtrOlubdlaAHaN\n" +
                "76923.4:gals:FrhYqGpPafeVIUEr\n" +
                "57447.1:qts:SbPjksZrahlOmjwIPUzUHH AdGF\n" +
                "109916.3:tsps:hfWaaCJrumLCGbZzDQuuKBiE\n" +
                "3107:qts:wCCNimdsbaGjQXMdMADSDQMwwZbbZBNaTitQnc\n" +
                "58815.4:gals:MFBcvKjbCjatoZ\n" +
                "45174.5:cups:F cUNQcON PIMwifzbetPufCShtOaXmHthBKGVW\n" +
                "100522.8:gals:OWTfhjDlhRHEeCxNMUqRFaZXgCzQXuKYlwXStly\n" +
                "91730.6:gallons:RKUfcGOmQoHkRShxXpbdPxBt\n" +
                "77072.4:quarts:WslzNyRyLEehIH AABqFrBlSv\n" +
                "61652.2:qts:nEogSarDzEITQhGnedqPBzmzYZIdBsEevgeUjRyQJClZ\n" +
                "60863.6:gals:UTPiULiQkZrskrGIEhDrRNNOEMBaBajoSPtSfUIHXWOltrgz\n" +
                "114606:tbsps:JlCYjEieSJKrcRzGaWn\n" +
                "24018:pts:vQMKifqluMPrTSensYHdjOntcwBkqeC\n" +
                "40128.1:gallons:UYkPfYyX\n" +
                "71288.5:tsps:MH vTefcAAYo jJvwzyqDfOWTRHubkcqZt\n" +
                "55832.7:cups:CvMtkMvygJG\n" +
                "55131.4:teaspoons:ICScibiqcnSG\n" +
                "14932.6:quarts:DM leQpyQWMxZybMPCVjCpliOja\n" +
                "12768.5:tsps:nAPuuBExGofBNZJdDuLQQSUelBkbilFtftgR\n" +
                "3723.5:pints:E\n" +
                "47223.9:teaspoons:UgOprPpWHa SxghKasMpLPMa\n" +
                "108503.5:gallons:etoawZZWvudAoAiAtkoaHmHDiigsujbByVoENZqTKdU\n" +
                "109872.4:tsps:TuhBkfTEXIOjniRUsTsGGpDwqc\n" +
                "32974.7:gallons:L\n" +
                "7499.5:gals:wB PPsJbJyExUzSIoSwGxpTHjGBeyZdTKUVqWgZ\n" +
                "77018.9:tablespoons:RKSWEZxvVHZqzHIjRZcktHgqioAwvwHVybqDyuKVabREXQ\n" +
                "95113.7:teaspoons:ejvM ZmdVlqvLeCQzs\n" +
                "83109.5:ls:PgVWARVrDuRtjPsgHSFjPECKuKMaCBLiSIRqtW\n" +
                "23831.5:gallons:QcGzshGLCcDWblSMqRXuE\n" +
                "107178:gallons:ciJEWvxfzdsr PgNeL XevHsA\n" +
                "11905.9:pints:mWd\n" +
                "86155:quarts:ULYmcC\n" +
                "45784.6:gallons:jLbbvvNdKqP\n" +
                "97594.1:tbsps:VfvMPgTYVOkZfOF\n" +
                "33544.2:tbsps:QOwJCgOBTcv\n" +
                "103169.9:pts:MFgMQepPqHINwmLpqrmX\n" +
                "22182.4:ls:ZqMwqItVDaTipxDwy\n" +
                "58653.3:quarts:UYjHnTMmbSluckwIXVjoTqwalePRT\n" +
                "85964.6:pts:WG KFkFrlMYpxsXrgQUVNqRoUrBw tFBrirTAJpA\n" +
                "120616.4:mls:qgKYRIzVksukjhWHEbgYbCUP\n" +
                "43774.9:teaspoons:b\n" +
                "28593.5:quarts:SWjhproZW\n" +
                "22742.6:tablespoons:go hIrRxVPfziFufpQQwcglFx\n" +
                "20723.7:fl ozs:mQhquAwOCHLRSUzcyaNdDgLLsZt\n" +
                "1352.4:ls:ZVaBAvylUJErtnjetvHGEx\n" +
                "49715.8:pints:HTMrvPnSR PIuPrLTkHoL\n" +
                "28831.4:gallons:tj\n" +
                "52324.4:mls:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "115369.7:mls:KmwfMVTwSeRbHCuMo\n" +
                "6439.7:gals:RFLBcbgxvWvFuXiUVFCcykrVrRdBlcHHKWUEBmdjinCPdh\n" +
                "65676.1:tsps:aFFUzbyatbdRUDXhYME\n" +
                "118136.3:tablespoons:IkdbcPSMUNsLEkBNWcSmkl\n" +
                "41010.4:fl ozs:IFFmzPxNQmx OFQaUIBvuRCs\n" +
                "80181.2:tablespoons:onMX\n" +
                "110760.5:pts:SdlAkZbGkjpfTzTSteWNJGVjTAEwh\n" +
                "32093.5:milliliters:LDTTMjAXRCeJObJKBBDuIzDfs\n" +
                "8855.6:milliliters:mcCHyVJVYNJFsjGOVoyUNPuyYLvQJNapJnUDSjxwu\n" +
                "57379.2:mls:hYOhHWIjSKbtgXDqStbVNvbVUuZuKMJCnhglgirSrMQfDi\n" +
                "107814.4:mls:TX\n" +
                "51283.8:mls:oEOyuEvSGcVZUnzc yBaWEiwMuUVWhbqlddhIenZqT\n" +
                "14177.3:fl ozs:PDvfgSsTkBYKdVNQUnSIYdwQqPL\n" +
                "38700.6:liters:YaPkXOWkEsuvnkNU\n" +
                "54544.3:gallons:hFIuKIKzmPRsszoqGmMkrcqxRzhYlxjqf\n" +
                "7013.6:fl ozs:FNvmUTTKlgzHSbcZRqlXGJZLfCKtkmRPS\n" +
                "108276.3:liters:ZoJPLrqxljhJ WQyXKRWXAV ve\n" +
                "77409:quarts:XfXqjCPebnM\n" +
                "11572.8:pts:sXRbRzspDrZoMKhHXCZaCcaWoIAudYo\n" +
                "75594.8:teaspoons:jgLhuNmBCAykkfRxKjwVtoMwnYZvKJ\n" +
                "114240.9:quarts:CjEsZvtvaPgtdgzxsxplyCu xdOub\n" +
                "89102.3:pts:FNvmUTTKlgzHSbcZRqlXGJZLfCKtkmRPS\n" +
                "25567.2:fluid ounces:cRRZNrQzfKbuhQJjPLbtCKotufxa\n" +
                "58271.6:quarts:YiA\n" +
                "39934.9:fluid ounces:ZkXwJQRCEeZsUgbLOsvWNHkju\n" +
                "48449.2:liters:kuRXeiMEprggFpHoWDeTFoeZz\n" +
                "92389.5:liters:WOAjIExldAXiru\n" +
                "119934.2:tsps:hV KHwDaftgKDcghzVPQaTStGqNHSQHUDzsULpgfgInA\n" +
                "73776.4:teaspoons:QYBUDA JNihEvRcsKOQWmJMiaaeYgrGtLIbYQBLhYppWnBp\n" +
                "84161.6:liters:mCvZNwPTrRlXxVkklbATkFKjgMmVSNKqeut LoUnZcfI\n" +
                "46864.7:pints:auUc\n" +
                "82212.4:teaspoons:lHBWLPUKHCXCfNEs\n" +
                "22683:fl ozs:nvYVjiqsVlTKWbWTpYJGVpxhhG jbCsDwYQRzfa\n" +
                "6331.9:cups:Oxsjc zlSYWjTHES\n" +
                "77887.8:teaspoons:eyzAlQ\n" +
                "26109.7:tbsps:aUkZTk uodeDmvY\n" +
                "37125.9:cups:Ph vUVCCbZawJdrrSun YAIcZiIcXCLAa\n" +
                "96866.5:gallons:NYzWxKzkYezsYYqukajMxFDtONtl\n" +
                "61398.1:cups:tjYzHUwMjffBfVJSOAYsMeZufqmcmOIcQXJeSBzAuFo\n" +
                "65248.1:fluid ounces:HhIfWnIvrpihoxJU\n" +
                "12482.1:gallons:PpzTsHdpTpofkBSzsp\n" +
                "11779.4:pints:nILyDrxMSjPaTawwSVQST\n" +
                "45405.7:tablespoons:OwWXeMhejvVrSYpPiAsYtbm VPilSWCUNvgGIpGTDI\n" +
                "99660.5:tsps:VPDByvRDCTEOeKhrDswQKmwGCWyBENs\n" +
                "51190.9:tbsps:cWFMOgTnYGQDDCuzHHLDucKhWmiwAmXdtrOlubdlaAHaN\n" +
                "8564.6:teaspoons:wEsFjEfSnFTyFY cxdpksTxvttHHyJFDLEwpNlnxwWTkDiVz\n" +
                "10489:tsps:NWuDFoVUxrzdevYd\n" +
                "55382.7:cups:VAG HklcPHYIahtdm\n" +
                "99220.5:pints:SbPjksZrahlOmjwIPUzUHH AdGF\n" +
                "22976.7:pints:pw QBkAynYBBmadDJrtnWTpyAPbinEVle\n" +
                "12556.6:ls:MoGzqQuKrPortXsSZGIxhHJcIFKkdPJJwfkTvHgirSh\n" +
                "17977.7:pints:x\n" +
                "68963.3:mls:oPwcvBGfqUdvcVCprJpQkKRzxvoqFR\n" +
                "5224.5:mls:YVkAqpUVPDfEewhsOXoAzgTTSYysMraNca\n" +
                "96903.7:pints:ftOQCydzwsbGcTSZLjEhaGyJTqyItjQolHhVW\n" +
                "93619.6:fluid ounces:bnElYYjjaHILgRDfCBwL mtDBGuwIqDXfdxLMoVPyKb\n" +
                "100346.5:tsps:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "35096.1:pints:rTygBowfvhzaZwrqTSafNHQTB eEMgBhwwgrmiP\n" +
                "111985.2:quarts:PrGiAZMpIAgHlOupOHcTonRnjwT\n" +
                "123428:teaspoons:fNXOtqixaVMJNPsqbagwpplXMhzQP\n" +
                "47044.3:fluid ounces:qnOLpMJmkIOApjVD bHC\n" +
                "92447.2:fluid ounces:zfgk\n" +
                "61991.2:fl ozs:UTPiULiQkZrskrGIEhDrRNNOEMBaBajoSPtSfUIHXWOltrgz\n" +
                "105354.7:quarts:ysAKFJCSiAUXHPprgqtXoAbvUKNPCqm\n" +
                "110500:qts:NIunHiSLRvValQGXZkARQVrnLz iVUtrVjrBysHlV\n" +
                "38179.5:fl ozs:JOTbKZPkqxECCHDCyRyT tB\n" +
                "14230.3:gallons:STlSILYQyEvUsrbkISxfvGl lpzzrtimikeQaLyQr\n" +
                "58229.8:tsps:nUYrXqmPpXuysWUOadX\n" +
                "102892.9:quarts:VAG HklcPHYIahtdm\n" +
                "107457:tsps:WOAjIExldAXiru\n" +
                "20671.1:milliliters:gnEhiqCxmxkwoikwZmMbdIcJ\n" +
                "102189.3:tsps:PhKHrk\n" +
                "17843.5:pts:CrJSNfikhVOXgcqHBxymvsgDaruYOmB lJOrIhLNEib\n" +
                "119025.9:qts:CHyQfQIohpa\n" +
                "54939.5:tbsps:HQLtSpkkwEslioTmaCObHjwBeCNmgzYvvKwkZKbhtaWqM\n" +
                "101322:gals:QzbzSJryltjRHlOlKimFVYjLEAqiCAYFvoPWPQkcUHip\n" +
                "25696.3:liters:tj\n" +
                "34799.5:cups:hdzvmMQChJlHGhIQGGRXsxpHzZcevgJhJ Q\n" +
                "32086:milliliters:icxgmRpwXJMJyASyUu GgPL\n" +
                "93927.5:qts:BPpgrUYLRjw JeqL UuGLjRsCo\n" +
                "40655.5:gallons:OOQWIzDjdtxxJGasN\n" +
                "55457.6:tablespoons:Ez fDWOHkeiaOsFXMuIUWgUwfsmdGivVLgOlqMw\n" +
                "72388.5:cups:bH ZFOGqRMDTjIoWq\n" +
                "108687.7:liters:FNvmUTTKlgzHSbcZRqlXGJZLfCKtkmRPS\n" +
                "9208.9:pints:ULYmcC\n" +
                "16860.3:qts:SeoTxl MoeQOpQgggLU\n" +
                "104748.4:ls:ToOKclb\n" +
                "103181.2:ls:Ahcm\n" +
                "38130:pts:QGiHEoyOYrXQTaCYbMIbhsTiSsMYUumjSfGmQEMMoxEdPB\n" +
                "121591.7:pts:xuONFMNyTVwNLopRDbEXFjXhWwLhNzlTCTC\n" +
                "108476.3:quarts:QHuqngNABCWirJXeklroJhgUFwJ\n" +
                "115717.9:teaspoons:NrGAfngnnDKaVilIQJJlStleIXTrmpsdG\n" +
                "10241.5:pints:gBwEplh\n" +
                "119166.1:milliliters:dFrSHqqDCqRghXeoPlUXVsn\n" +
                "2410.4:mls:UnPGTIbllpQ ZwGfnReVTTEPgqkOkPDYc\n" +
                "44597.9:ls:OojaTlAPTYrYcTi XeBmkFxKb\n" +
                "57985.4:quarts:GZqvHoADCGNqAxslAjrPopnG WJMUCQweJpswJRxbHGHU\n" +
                "47160.5:gals:wmZ\n" +
                "56779:gals:CIhdLoOvwJtPzDbPptfPWhFMIF hwzFuXElSrd\n" +
                "45034.2:cups:bnElYYjjaHILgRDfCBwL mtDBGuwIqDXfdxLMoVPyKb\n" +
                "32728.6:qts:MvMBMevUMioAhvKfqrsFouo\n" +
                "77718.7:fluid ounces:lpIUDbgHlmcKJjxHgrKMnXBqOalNJeJPpRCeCwRnhECDSe\n" +
                "64120.3:qts:aFFUzbyatbdRUDXhYME\n" +
                "21878.3:fl ozs:GBnkrXkLNHUfeCDeyuIeYdHcAnxwxaLoeJToCz\n" +
                "17330.1:tablespoons:EjbtiysSwROsisSJOsEANC\n" +
                "11579.3:qts:AGDXsppdqiXUykWMRVDZoIcBsuIgg\n" +
                "28716.9:mls:HgQBGCxnZaaPBQABlFlxRecpPonszpuX MsMupizDJmuI\n" +
                "122343.9:pts:MFBcvKjbCjatoZ\n" +
                "108841.4:ls:vsRZNaozH\n" +
                "26918.8:fluid ounces:kxlZxGog HMeTeBSiTx\n" +
                "79320.8:teaspoons:hopmacAHYEqF\n" +
                "61496.1:gallons:W\n" +
                "103077.8:pints:lcJdxottPUJcCOCnKIUMgfPqmKUeKEDVyukSmqqahWGo\n" +
                "82049.7:mls:IOFCi IRsahSYYQOBHgrsTpoXlevkXIoMDNt\n" +
                "22159.8:tablespoons:NrlxlIymvnpLoihhLjpqFxTC\n" +
                "106715.7:tbsps:VsBdokUqZPaWIPEBgggCLmPo\n" +
                "15346.3:tablespoons:RySDvlrzBdgqPWl\n" +
                "83021.4:pts:GqIdCbOzEYYOHsK hdOreiWFgoFabL\n" +
                "13531.3:tsps:YaPkXOWkEsuvnkNU\n" +
                "8329.8:tbsps:lTqrRjeRrtEBl\n" +
                "36683.2:fluid ounces:mXnFizNbhUfckIXp\n" +
                "50937.5:pts:uohkH\n" +
                "21654.2:mls:wCCNimdsbaGjQXMdMADSDQMwwZbbZBNaTitQnc\n" +
                "19500.4:tsps:VyOpYirTdkdcpFEQaSGdkVxyMiQArRYtVwcEYurwjZo\n" +
                "122954.8:liters:uPYAOb\n" +
                "78181.1:tbsps:dSfzeoIPCeLapvVm whoLLK IIQYSicSqEQYgafiAcbxucH\n" +
                "46270.8:tsps:LuqS\n" +
                "56140.2:milliliters:vjPKKsFrUgM\n" +
                "54192.9:tbsps:G  BAbtWHlwzMjxcpDVmmSbCyRIhSTyvKbFawoHjzaUJsWuxm\n" +
                "83358.9:pints:gTOepZRFDZzflxtD Oq eQrEBJKFkIiOUQNeVnrcgjJd\n" +
                "65946.5:liters:uWiKHBcMgCjPxAOYeOtYcaLTKaqv\n" +
                "102901.6:pints:iUFnAISBIAEMoTpqqBrCvEAhpsqeN\n" +
                "47547.9:fl ozs:Xpv\n" +
                "92195.2:quarts:ifak\n" +
                "104451.9:pints:BnFl cjfVOLWDOixWewHQXpnw\n" +
                "35624.1:tbsps:WlShfNOmwXrlvYQRbwzflHuyPHTJ\n" +
                "10741:fl ozs:BnFl cjfVOLWDOixWewHQXpnw\n" +
                "109691.1:fluid ounces:RKSWEZxvVHZqzHIjRZcktHgqioAwvwHVybqDyuKVabREXQ\n" +
                "32410.1:quarts:UTPiULiQkZrskrGIEhDrRNNOEMBaBajoSPtSfUIHXWOltrgz\n" +
                "70812.6:tsps:bRjb\n" +
                "92521.7:fl ozs:IsDmxTVActtmMW\n" +
                "98091.9:milliliters:lvV\n" +
                "95264.8:fluid ounces:GpQlkYDmtpNUydCtIBuUkGB\n" +
                "69778.3:tsps:KPBcEvvJO\n" +
                "58949.5:tablespoons:hCLvTtFLkKFRmSbjUaDhUTcCKzWgnThAcqZjA ZueET\n" +
                "82489.1:mls:krfRMCIRSEKuYPIrpqcxWqTJLqO\n" +
                "2041.1:teaspoons:abVnpVqKPFwcTjC\n" +
                "4239.8:milliliters:gSLxPsYpjrktwKOPCTlJe NoNVGbvJpAYuBlmFSKBXofmGqDp\n" +
                "115852.5:gals:QxUhwXOkLSthwDSAZIaiAlsvJHyyKkrnr\n" +
                "114062.9:tbsps:cg NEtbHAZIkQwuPqKSLVdTiMRhznNGyywXofJN\n" +
                "42647.1:fluid ounces:PhKHrk\n" +
                "22291.6:qts:mWd\n" +
                "41127.2:teaspoons:ZUuq ByaoygQzjNvEP yBKsiLFw\n" +
                "72944.8:mls:ZyFQMkTbUZlROMVCNZu ih l\n" +
                "43349.5:fluid ounces:BsKZhLXZskOEApUYXbALKWxG\n" +
                "56238.3:milliliters:ZkXwJQRCEeZsUgbLOsvWNHkju\n" +
                "49687.3:tbsps:dhhGchAFFhnaISRBTfGkNOaxkeA\n" +
                "9902.4:tsps:pw QBkAynYBBmadDJrtnWTpyAPbinEVle\n" +
                "35025.2:gallons:ZgXsNBkcbrASOcIQxwvJeKIqvsSVXGNToDvZBUUA\n" +
                "45254.5:gals:usOYTa nNAbCCwyWzs\n" +
                "56064.2:cups:jbGbkSWsviSU mbYvFrfqNICEJT\n" +
                "86477:pints:UsVjm\n" +
                "29484.6:ls:KyaKPxnrgIUKKfvzOdfoTNoocFUzDFnVCLjtbnkn\n" +
                "20297.9:pints:JlbwdXPXmBN\n" +
                "98434.5:fl ozs:oUbnGidOimWNQCPAydFwCXBGkAGYANjZFaV em\n" +
                "96219.6:pints:ieMBnJVUkrReRdoURTntwTjCgASnlkOKVVuoEfH zAiWfC\n" +
                "82897.8:tablespoons:uTGUEiQuioArLhaoSZUfLBGbbgCRUgQxbBOhQxGByd\n" +
                "124705.8:milliliters:WjQyKJLnjWxmSzQAvHYQoXcNvDgmpWL\n" +
                "35968.9:cups:SFquOMpO ET\n" +
                "121301.6:milliliters:nxLkWi yQDWMOoYSOnJIRzejaN\n" +
                "31089:milliliters:ZzsgFydxlpTXNppyUnamiIfsCYdkbII\n" +
                "44993.5:tsps:WlShfNOmwXrlvYQRbwzflHuyPHTJ\n" +
                "115451.6:pts:CHmvB\n" +
                "100818.9:mls:LSzeWXVszNZPnA T\n" +
                "53581.1:tbsps:dncXeDfSHTiOdvIeAQyFlodLkgkcrxr\n" +
                "83526.3:milliliters:xxXyhhhvxcGUSWVuhiENqvOy YFgklPRYeMYSjUeHm\n" +
                "24966.5:tbsps:KdfdaslciREOi\n" +
                "109022.1:tablespoons:Sjm YBVywVWenkYHYPQOQccQAkvsxHnxdXbBwdYajqi\n" +
                "91784.8:liters:WuVYBwoGcBjhwXhIlLerAyPH\n" +
                "78991:mls:Zz\n" +
                "20934.5:cups:ulIpbh\n" +
                "43010.6:liters:kwfkBHbLRh muKtPPaFCRwGCTpHv\n" +
                "46207.8:liters:CIhdLoOvwJtPzDbPptfPWhFMIF hwzFuXElSrd\n" +
                "119051.9:mls:eVmlUqDAYOfnDzPxDhfazCIVtutPHfCGDXTDYOKrjmgj\n" +
                "92823.7:tablespoons:EIdmMXoYvaJeqHDTLzVeWna\n" +
                "16430:milliliters:dFYVkqkjsVGJPvBobwmjeH\n" +
                "87011.6:milliliters:naHhKnXkNyNpHmMxBffqcfVvlNCecOJdwlHXBHvK Mxtagc\n" +
                "18288.1:cups:xKild\n" +
                "34000:liters:iyGitLYbvSRVZfhHLDVfSsMTNICNAFqQCHfCSkCiJZTibFoD\n" +
                "101495.4:milliliters:ZVJtQJ hcMfKtExxCvUmiAoKDOTkAo\n" +
                "42331.4:pts:RFLBcbgxvWvFuXiUVFCcykrVrRdBlcHHKWUEBmdjinCPdh\n" +
                "44445:milliliters:KdfdaslciREOi\n" +
                "89692.1:cups:JKbbImpICuH\n" +
                "113069.6:mls:b\n" +
                "102459.9:gallons:PmIOWZnnVtwVd\n" +
                "123373.7:pts:gnEhiqCxmxkwoikwZmMbdIcJ\n" +
                "14764.8:gallons:hEjCwbrBJ\n" +
                "6840:gallons:jlZqBoYADLyFv\n" +
                "123109.6:qts:jxzMWrNR\n" +
                "930.8:fluid ounces:SWjhproZW\n" +
                "11973.4:fl ozs:WUjWTEEqPibis\n" +
                "76693.3:qts:iMXtAIFeUOttDkXNXdb JurlbjgVBK SDsVAv\n" +
                "97653.6:fl ozs:oyMenFxTKZMFHPRiwdYRXPgnWDGUJRR\n" +
                "39289.6:tsps:gx\n" +
                "119805.6:fluid ounces:iQ n WZsYOZNFmOKTJIfzCRTQYDfunQXWMmAuG\n" +
                "13250.1:mls:rZegSZdiGtdruwaiaGnoLlRKkzBASHtQTgLy\n" +
                "90423.2:fluid ounces:HDJ\n" +
                "53238.1:milliliters:GpzSzuIaVWORRVbzdorHobuNebrhrPTK\n" +
                "100288.6:tablespoons:fFR DGSowXeouIe nXEtDGKWxELYyo\n" +
                "58298.7:liters:FAZDZJxDmbSZKJiqyHMtYJ AAKsPqlGeVItaZIOcP\n" +
                "56723.1:pints:mQhquAwOCHLRSUzcyaNdDgLLsZt\n" +
                "98038.5:tablespoons:kUjfxpvi\n" +
                "7794.6:quarts:zVANFIgVo\n" +
                "13730.4:pints:cWFMOgTnYGQDDCuzHHLDucKhWmiwAmXdtrOlubdlaAHaN\n" +
                "78083.5:quarts:tCzx dyiHsLJVKDNJaQrmQiaORsTNFHEMIChnxcMX\n" +
                "49679.4:tsps:DyL\n" +
                "57941.6:teaspoons:HNHXzTrdGmfV BvajmYMTiwPl eQyVJLAuikn\n" +
                "121427.2:pts:nVMRvS\n" +
                "36273.7:qts:FAZDZJxDmbSZKJiqyHMtYJ AAKsPqlGeVItaZIOcP\n" +
                "97378.5:gallons:LimlkXvFN\n" +
                "24825.9:mls:mVIPM\n" +
                "74956.2:tablespoons:IQVtxhmVgbgamhBfiKOnSmHjRZrqIXvNyK\n" +
                "58994.3:pts:oyDCmvsewAZAcwNIBtsTuz TxiBXLcyNK LWGPVz\n" +
                "72517.7:cups:mtrfdIROnxaiZcyOpp\n" +
                "111226.6:teaspoons:BQC KacHM GipStTy l\n" +
                "63048.7:tbsps:abVnpVqKPFwcTjC\n" +
                "104236.7:gals:LuqS\n" +
                "26444.1:tsps:ulIpbh\n" +
                "115419.9:fluid ounces:IiwZAQLcEIhzecVaxUHbQqGhJMIrBeeTkUsyjVXk\n" +
                "28175.5:ls:RKSWEZxvVHZqzHIjRZcktHgqioAwvwHVybqDyuKVabREXQ\n" +
                "109624.5:teaspoons:zUdU\n" +
                "37964.8:liters:lTqrRjeRrtEBl\n" +
                "90776.3:gals:IMwvSRBbExKzXWtttNAyg\n" +
                "60640.7:cups:LygwYMHrIfwlGYSIoTbMxKbLYYnPLXAimRUzPNpRKwo\n" +
                "20191.7:gals:weCD\n" +
                "71756.6:gallons:EDLLNYfZFrVOxUQxUYefVJZMxeWCGmIPIoIpo\n" +
                "88478.3:pts:vCVzKvCnqDOUyeBtdYBDZuksNxcjiSDxvZhl\n" +
                "121726.1:gallons:eehbGDbtWDEkdCoufmuiVpwtyjaRzYWDnIK\n" +
                "17772.1:liters:hgPabLICYBnjhGrVCvFEiKBUMOJh\n" +
                "65567.5:mls:dBIjTlpQlEigeyQKdvMo\n" +
                "34722.5:liters:vhOAgOrqnTMZFSGkJNwNXly DQGwkKDbevwp xsr\n" +
                "105484.5:pts:dZAnjNeZArLJsQEXEgDfHSCBbwLarzHogtGvUmpC\n" +
                "90699.5:quarts:BmJal\n" +
                "23541:pts:kaeXWNkIzErBHoxaljhzWzfDBUwtDLQ\n" +
                "118346.9:qts:WzfhYRylAsoBiYbQEBWURnmLHskOxIpbjdi\n" +
                "33189.9:fluid ounces:HBWoXZzJIAPtIxanemTyqvvyTovWlO k rdnGqmEsOpFjX\n" +
                "82071.7:teaspoons:ZyFQMkTbUZlROMVCNZu ih l\n" +
                "94439.3:liters:gOBwGZGGngzuI\n" +
                "33780.5:quarts:NIunHiSLRvValQGXZkARQVrnLz iVUtrVjrBysHlV\n" +
                "123566.6:mls:cGfmHzOQgPYNlaXjup NEBzsdvfJvMjyM CZAzbhrCAUARbe\n" +
                "72367.4:gals:SeoTxl MoeQOpQgggLU\n" +
                "70637.9:mls:QAWhTdfimYdrbbStgYJGtsZG btAFHVRpwgAFczYfgh\n" +
                "30265.1:pts:eaNNOuatA\n" +
                "9364.6:tsps:auUc\n" +
                "121026.3:fluid ounces:oTjJsVIaRAsIIgzwACaoMbcdHOYEvJbrBvRusdezcWlMmnvHu\n" +
                "11553.2:tablespoons:DHqaUpruHaRshBjIKPWbEfbzezGCp\n" +
                "115871.1:pints:Ltwbxuya RFLEnYOduT EjbaxUS\n" +
                "24064.4:gals:EYasjYHjMvJXGGlMAOt\n" +
                "122175.3:mls:vUpihRafUKOlALPkEJnvZyrbkIuMywzLnqPLKeUFXb\n" +
                "121462.2:quarts:vQMKifqluMPrTSensYHdjOntcwBkqeC\n" +
                "52765.3:qts:laUNDUmrhFP\n" +
                "97265.5:ls:lONMwymP lH\n" +
                "53436.5:fl ozs:bFIYTmlKHflaSQUwtelDy\n" +
                "100058.1:teaspoons:vqaudgLc unElCxXDFKKErBGwbgZ\n" +
                "117402.7:quarts:KzNDtkcvMiTsKsW\n" +
                "113156.6:fluid ounces:VF\n" +
                "87587.4:cups:xfXqCcj\n" +
                "92728.4:gallons:eJVkFESffLOWa\n" +
                "123393.5:milliliters:OMYM MWuruZhgZVcny\n" +
                "2718.1:mls:gx\n" +
                "118744.3:pts:TcCJLV vcsRfNNXPvMxzBvGqXUttKQJ\n" +
                "47535.8:quarts:yrDoLkMx\n" +
                "8869.4:tbsps:M\n" +
                "53888.8:gals:IEWy\n" +
                "56867.9:pints:CrJSNfikhVOXgcqHBxymvsgDaruYOmB lJOrIhLNEib\n" +
                "25583.9:gallons:GrYmScHzryZuXcxJvGwgqvTycpjebpUTSr\n" +
                "103266.7:milliliters:HQLtSpkkwEslioTmaCObHjwBeCNmgzYvvKwkZKbhtaWqM\n" +
                "91362:quarts:WUjWTEEqPibis\n" +
                "115475.5:liters:RKUfcGOmQoHkRShxXpbdPxBt\n" +
                "17458.8:pts:KmwfMVTwSeRbHCuMo\n" +
                "30350.7:tsps:myzVshjaqEki aWtsxREAScyNsAWMEusypBuR OzOH\n" +
                "57042.7:qts:fWPshEem SeWgxBuhvVAzrhOVXACZVYMJZ\n" +
                "123542.4:quarts:RfcCXdFi agop\n" +
                "48681.8:gals:yfpLUscOvMrrBKCjp PlpxtOvsALmSWIWlxwvNYmphgIR\n" +
                "10995.9:pints:NsSpP\n" +
                "28849.1:fluid ounces:WG KFkFrlMYpxsXrgQUVNqRoUrBw tFBrirTAJpA\n" +
                "53953.1:gals:gden SQxvctAYLKzalUiRktawZxqrUOUE\n" +
                "5924.3:teaspoons:xPfBMT uMoLzFgXanXUQq okCFgqrLRBjWdxib CtzKMZsj\n" +
                "118765:fluid ounces:JoVNvXQFywgQmXYEgLFowZbMtibOTvmNPEhunmaBnQM\n" +
                "43526.2:cups:HkBNNAwZiZWbxBTRWgvpuZAOrOLEGrPmjpEaL\n" +
                "54487.1:cups:WBHzxdDvMOwrol\n" +
                "85893.4:liters:uVsLxBGELLEHiGtpQxPXgj\n" +
                "106423.5:milliliters:acFsdmoijQuhQqSHGsB mEpCPYQWSzeyCLAgWMDbb\n" +
                "12535.4:milliliters:LL DxEXjUzKs UePcqCKTxmbNkZoBmETg\n" +
                "44680.9:pts:dPRXnVdQvgcRoYpbATRbXZKDezHONPlDoILuz\n" +
                "17217.9:milliliters:VlyHSt DFVdqdddDTyjWMoZInCERAMHQyQUGJLgaRHT\n" +
                "110366.3:tablespoons:ErDYJNcsDbWDIiOOWJDHexwtLr\n" +
                "92554.6:liters:SCnOAIq ZNfmuQMtoHkrOEjDKbvsUFkzAxuhHqjWowz\n" +
                "11229:tablespoons:IsoSDMJu\n" +
                "34802.8:tsps:JoVNvXQFywgQmXYEgLFowZbMtibOTvmNPEhunmaBnQM\n" +
                "94194.1:pints:lvV\n" +
                "119545.4:tbsps:X\n" +
                "24763.4:gals:TDJcbOIcofpmAcojkTzIBCpAVNsYhPEQGZLwDpyJjYNvNg\n" +
                "31712.2:tbsps:aUkZTk uodeDmvY\n" +
                "82383.3:milliliters:YBIoGcPOBdkdXHLtwyHZOcQqFOGAYYnsZKwtDTUlVOm\n" +
                "54846.8:fl ozs:oUbnGidOimWNQCPAydFwCXBGkAGYANjZFaV em\n" +
                "34712.5:quarts:b rikFChXnPXyuDaqMbCkomQSNwZm\n" +
                "124751.7:fl ozs:UOemVamkpcsWKJsBWLM NRjLjqsEStJRRK\n" +
                "72386.2:quarts:AZtqCLpnFgNatFET DRjcHmyCgUgDYwhfRrr JDsdYNXGPBjA\n" +
                "48826.5:tsps:ejVNoMVcDtfMYlJIqQfbyVUc\n" +
                "6131.1:cups:EkgchMWsf\n" +
                "80567.9:fluid ounces:dSfzeoIPCeLapvVm whoLLK IIQYSicSqEQYgafiAcbxucH\n" +
                "73987.9:fl ozs:pquKaeuxh\n" +
                "41854.7:fluid ounces:IkdbcPSMUNsLEkBNWcSmkl\n" +
                "115015.6:milliliters:epTxCAMvaumWUBoZMqtHLwJB RCBjJdwniSSBvHPLQkQ\n" +
                "13140.8:mls:kKWaOxsxDynqKaSlDbj qmIdYcVNQmoZMYa bCxVXr\n" +
                "55294.2:liters:NFifIMmiOKBOyBCnBaGvnaigWAUHLu\n" +
                "56400.9:fluid ounces:UoVlCzut VQPEyTYms\n" +
                "6915.3:pts:rgoqqsQHAhdZLHAEAzdBGsuJzQJIlBGmoJdRyb\n" +
                "42373:teaspoons:PFQdeNPeatmTirRUtxxNKLmqwLWaoDJaLPgrXbnYZwcXKzMIH\n" +
                "84971.8:milliliters:ZVJtQJ hcMfKtExxCvUmiAoKDOTkAo\n" +
                "11048.9:qts:UvcLqwnXeCeBMtpfNKGdpOzNhVxMTiSHFRtSqMYXJBIOISCP\n" +
                "99487.9:qts:GZqvHoADCGNqAxslAjrPopnG WJMUCQweJpswJRxbHGHU\n" +
                "123742.8:cups:cIfEtzQmZNAJItUFmhiRHlblb\n" +
                "34476.1:milliliters:EIdmMXoYvaJeqHDTLzVeWna\n" +
                "41752.4:gallons:qstWYQtHSasdaLN JUkz\n" +
                "56232.9:gallons:bXpmEXEDmPuvFqXIPOxWVsam\n" +
                "105816.8:pints:OWTfhjDlhRHEeCxNMUqRFaZXgCzQXuKYlwXStly\n" +
                "60928.6:cups:MFBcvKjbCjatoZ\n" +
                "99817.1:fl ozs:EkgchMWsf\n" +
                "50168.9:pints:rUQYmbJa\n" +
                "28128:tablespoons:ihzj\n" +
                "54825.9:teaspoons:LSzeWXVszNZPnA T\n" +
                "63396.2:ls:ySYLsKlUpfyPc ncShDwaovWeHHwVStUoGznMYG\n" +
                "49011.6:tbsps:IZWCeDepboRNEv\n" +
                "27075.1:qts:nreUZQHPyHsAptXuCfbhwktnK\n" +
                "102637.6:tablespoons:qucHkFeezRUXLXpwIuCIzCCYsvqwwL\n" +
                "42350.6:pts:fDiiYdmtXRDX\n" +
                "80501.1:gals:SgiEK jPpyoyMFZAR joYiFIDwvcJrJl\n" +
                "107155.7:gallons:MfXK OEMpLRogWNjybHKdPZxLDBwbaqT IIUrJxpdUgjb\n" +
                "29274.2:pints:gZqrNFQQZPiJUqTIFLVTLvhcpMislHcqxuUdotCMxg\n" +
                "49177.5:ls:ZUuq ByaoygQzjNvEP yBKsiLFw\n" +
                "33131.8:pints:XfXqjCPebnM\n" +
                "92575.1:milliliters:ZyFQMkTbUZlROMVCNZu ih l\n" +
                "51432.8:milliliters:nStyLSieq RyJ\n" +
                "68405.1:teaspoons:qstWYQtHSasdaLN JUkz\n" +
                "17758.8:fluid ounces:edXQkyGHfuUtuCQB PmIJUzkIDPDz\n" +
                "64298:ls:RKUfcGOmQoHkRShxXpbdPxBt\n" +
                "114192.8:gallons:KnzZtxbCdssmB feDHOrjHcq\n" +
                "15062.5:liters:QQWMPrGNZTOIFUePJ DYxDOcFHRUFa\n" +
                "34113.1:qts:QxUhwXOkLSthwDSAZIaiAlsvJHyyKkrnr\n" +
                "102221.9:tsps:QxUhwXOkLSthwDSAZIaiAlsvJHyyKkrnr\n" +
                "80193.3:mls:hSlRqmPLjrZACA QJ RjvmdFrhMgTtcD\n" +
                "26279.7:gallons:LL DxEXjUzKs UePcqCKTxmbNkZoBmETg\n" +
                "96257.5:teaspoons:ctA\n" +
                "53936.7:gallons:NFifIMmiOKBOyBCnBaGvnaigWAUHLu\n" +
                "92321.2:cups:BfPXykeTVBsfcKmvtpwTAFFsBeuXeOqOcKrwPhP\n" +
                "45423.5:liters:HNHXzTrdGmfV BvajmYMTiwPl eQyVJLAuikn\n" +
                "23045.7:mls:SDhwx\n" +
                "69672.9:tablespoons:Na wLOSeWO\n" +
                "28769:fluid ounces:PfaxQX iqYHOwunpvjx\n" +
                "58247.2:ls:ESPcMWGvxtypkCTQFPhWPoiY fZjUGCPYg wFjBcBduThKMh\n" +
                "1923:mls:naUaUn\n" +
                "106610.5:pts:GifmGZKhmuTCwAD\n" +
                "79003.8:ls:c\n" +
                "37228.5:mls:oEOyuEvSGcVZUnzc yBaWEiwMuUVWhbqlddhIenZqT\n" +
                "5253.4:gals:cZEtDNuSDNSQHNVAiACToFKJmCkgZaXFeVbTBXZaBJmZ\n" +
                "52171.5:teaspoons:qVywNnXggHaNb km\n" +
                "55378:fluid ounces:vqaudgLc unElCxXDFKKErBGwbgZ\n" +
                "112579.7:gallons:nAPuuBExGofBNZJdDuLQQSUelBkbilFtftgR\n" +
                "36490.6:fl ozs:uFyVP pCNsAvmSiTUuJQRZWCYIETxw\n" +
                "42221.5:fluid ounces:zyXrQahJDmdtTHLaO\n" +
                "81855.6:qts:HTMrvPnSR PIuPrLTkHoL\n" +
                "63980.1:pints:XzjWSNtnxDGYEMplPAbFfFEZuUdprINLKMdqiuKLQtoQHguJ\n" +
                "34588.7:mls:BqTHCmDDvBvsEeyGBNkiwJkYlpMAZwAEyzrYLrejXPz\n" +
                "115378.6:tsps:mAiqxxBYs\n" +
                "1356.6:qts:RZKwQQKCTvMqDgm rbjHLpwShvCUc\n" +
                "15374.6:cups:xuONFMNyTVwNLopRDbEXFjXhWwLhNzlTCTC\n" +
                "48855.3:cups:SFquOMpO ET\n" +
                "123190.3:quarts:DPNnmKRTAFoMdLKZW\n" +
                "55983:fl ozs:KzNDtkcvMiTsKsW\n" +
                "14569:cups:mmFyLVKPWpXEllmvA PVmJMLNoyAcbjB mFQPtwYpoAeE\n" +
                "117121.6:qts:QHuqngNABCWirJXeklroJhgUFwJ\n" +
                "64036.2:cups:SnIuyFvLXkfPmoLtlQDm SvSYWhetUsnuphoTyGSF n\n" +
                "35516.3:ls:ErDYJNcsDbWDIiOOWJDHexwtLr\n" +
                "100193.5:tbsps:VseNJyZrxFknZOvTnVSlRcrHrQBiyDsBeDlaJjDdzP\n" +
                "36646.6:fluid ounces:koqEpjZUTPjshtCctvZDVeIbLITudGxLb\n" +
                "10355.6:tsps:PyWJhQkiaFbWnj krQyCll sZzGQVwIOfLktvxusyBPraH\n" +
                "72210.1:quarts:Ci BPacbcxWIRsssUe\n" +
                "65121:fl ozs:wB PPsJbJyExUzSIoSwGxpTHjGBeyZdTKUVqWgZ\n" +
                "5545.9:teaspoons:qn DF\n" +
                "6828.3:milliliters:EQrlTDselCsMvlILHunz ex\n" +
                "46672.4:mls:PVIsCXJrifz\n" +
                "46192.9:mls:KPBcEvvJO\n" +
                "103949.2:ls:YPtaWcVxzQfigM\n" +
                "66905.5:milliliters:TOGUctXOZIZKewpU\n" +
                "116486.2:cups:SEQolvsbrwsdRugfTMuwOKUXd\n" +
                "33297.8:pts:rUQYmbJa\n" +
                "47502.3:fluid ounces:SCnOAIq ZNfmuQMtoHkrOEjDKbvsUFkzAxuhHqjWowz\n" +
                "26675.6:tsps:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "31590.6:liters:McaLZPxsYXp DhihNMgTCtAWXDmU\n" +
                "98055.2:mls:BqTHCmDDvBvsEeyGBNkiwJkYlpMAZwAEyzrYLrejXPz\n" +
                "19889:cups:naUaUn\n" +
                "95571.8:ls:lREQFphjixEFXzoOFcsazbiYEmRtwEffC  Afl\n" +
                "21439.6:cups:eVmlUqDAYOfnDzPxDhfazCIVtutPHfCGDXTDYOKrjmgj\n" +
                "92632.7:fl ozs:lpSNoHDXlJofrynf\n" +
                "62914.5:liters:RBqHVGVTkHfUDGdbKdUwCktUfQeiH\n" +
                "72954.5:mls:LMEsS\n" +
                "61898.5:liters:XfXqjCPebnM\n" +
                "97271.3:cups:WzfhYRylAsoBiYbQEBWURnmLHskOxIpbjdi\n" +
                "9550.5:pts:mQwoYzgsrEVvzEzvRaFjr\n" +
                "116587:pints:KPBcEvvJO\n" +
                "11221.3:fl ozs:qLYCMIEDdqVJYAfAFYkDKCtzrtcoKt\n" +
                "33737:tablespoons:LLgZTByFISQgViliWfPRXBJHdS\n" +
                "64870.2:pints:SbPjksZrahlOmjwIPUzUHH AdGF\n" +
                "86451.8:teaspoons:trOoonJkBQLfDDQJfkHBgEUnNzys\n" +
                "121127.6:qts:MaOKDwFaWLNmYrkBylVFAiMooRBzkYQnWgWshI\n" +
                "104217.1:tbsps:JKbbImpICuH\n" +
                "7746:fluid ounces:kUjfxpvi\n" +
                "123711.5:gallons:EQrlTDselCsMvlILHunz ex\n" +
                "124585.9:pts:hYOhHWIjSKbtgXDqStbVNvbVUuZuKMJCnhglgirSrMQfDi\n" +
                "95906.4:fl ozs:VAG HklcPHYIahtdm\n" +
                "44902:milliliters:Xvyu\n" +
                "120485.8:qts:RySDvlrzBdgqPWl\n" +
                "45073:tsps:UoVlCzut VQPEyTYms\n" +
                "90087.7:pts:vL\n" +
                "24563.9:ls:PVIsCXJrifz\n" +
                "26031.5:pts:DyL\n" +
                "73148.6:tablespoons:vZ eVKwWUZxOaMJtMfJeptGDumsUZ\n" +
                "15606.7:ls:EGmd\n" +
                "92890.5:ls:LWFravZtOLdWcuuyNDfnAnEmkpkNmDDzOxuyCsucXskkCPoyd\n" +
                "42587.5:quarts:BjaZSPsnj\n" +
                "6808:cups:hSlRqmPLjrZACA QJ RjvmdFrhMgTtcD\n" +
                "111616.2:fluid ounces:mXnFizNbhUfckIXp\n" +
                "120238.6:gallons:wmykm ITjNYAzgX\n" +
                "113708.7:cups:crynNIdEP\n" +
                "103766.3:fluid ounces:FrhYqGpPafeVIUEr\n" +
                "50645.5:pints:Za LIVCiaUwkxomfzUGgcKx\n" +
                "852.8:fluid ounces:PYpEpyRrmrCKAUApzfFqppo\n" +
                "64905.8:fl ozs:cNqGOOINDyDjUYGbXvSif\n" +
                "102288.5:ls:bxkmpmMEkXharDaEzLAdySgmBCnXXaP\n" +
                "44885.2:liters:xxXyhhhvxcGUSWVuhiENqvOy YFgklPRYeMYSjUeHm\n" +
                "55775.1:fl ozs:hWTgugBLzdvDkxtPkdZIoWWrXfadLBfW okvVqUIaj\n" +
                "83889.1:cups:ZJZjEmqRCCJXZWxfmyKOSp\n" +
                "117827.3:mls:jgLhuNmBCAykkfRxKjwVtoMwnYZvKJ\n" +
                "103383.9:fluid ounces:C kFKvpeZwRbuWhM\n" +
                "5998.3:qts:dZAnjNeZArLJsQEXEgDfHSCBbwLarzHogtGvUmpC\n" +
                "121652.3:qts:vhOAgOrqnTMZFSGkJNwNXly DQGwkKDbevwp xsr\n" +
                "105414.4:fl ozs:SnIuyFvLXkfPmoLtlQDm SvSYWhetUsnuphoTyGSF n\n" +
                "34027.2:mls:UhJvGEFLszZpiQzYCyEvqsc\n" +
                "52924.9:fluid ounces:kaOFgJi TePUE nKykYCMEsKH kphaFgxeMibbiLdYriKNoJ\n" +
                "4205:fl ozs:tsUMZUlRyMkaeeSQrImiseuwyw\n" +
                "60994.3:tbsps:vprjlfOWGQ\n" +
                "54556.3:qts:jlZqBoYADLyFv\n" +
                "64556.9:ls:BneQSrTZhes\n" +
                "36431.4:pts:NsVgNQhkNEWZzjRWEqfD\n" +
                "1813.2:fluid ounces:rlJEwAaQIafjzWN KVAocrStbJmM\n" +
                "95972:fl ozs:zfgk\n" +
                "84499:fluid ounces:hopmacAHYEqF\n" +
                "104828.7:gals:bRjb\n" +
                "30539.8:gals:GSoBV\n" +
                "59430.1:pts:mtrfdIROnxaiZcyOpp\n" +
                "92914.3:teaspoons:gnEhiqCxmxkwoikwZmMbdIcJ\n" +
                "46642.4:tsps:nAPuuBExGofBNZJdDuLQQSUelBkbilFtftgR\n" +
                "2455.5:pints:hwQa\n" +
                "39530.5:tsps:JscTukaScZWRakRViXThmhw qTVsCcXaEKpAksrxetYTTcwj\n" +
                "106804.2:teaspoons:WBHzxdDvMOwrol\n" +
                "102162:gallons:nkkWOshVHIppWLoyGX\n" +
                "117834.7:teaspoons:oxaKkQsKysFOQM xGdXUjsxClyhljYmdkWW\n" +
                "7888.1:tbsps:LSzeWXVszNZPnA T\n" +
                "19799.7:tsps:xhFbNrKCZAEmijARRRVvHtmorBkJxNiC Weg\n" +
                "112696.2:tbsps:bwOvNdDHR etxcWtYThVHkauFxsLWWwllJkOULg xj\n" +
                "95907.8:milliliters:LVEfPMLTNAyjVJGrHDaJNHNfhfsSkzEKOYS\n" +
                "68001:gals:OWJxzxtFpYxbiPVKMxk\n" +
                "32580:fl ozs:CrxlHUInMarCtpHtNQPiSjWqLvnEKyOQfLiy\n" +
                "112322.2:gallons:fmPkuqAlzlkrUPvmNwoMrepmBlBMoOGBmxubAwRwJgDfm\n" +
                "36811.9:gallons:QUrEHGl cjFH\n" +
                "100491.7:liters:UEfKbbcWDBceVrKlhaglscMlfuLtTb oEqtLx IvLlYYTa\n" +
                "923.4:cups:IqNwrMCFAOfWufzDeSOYxD a hciLlkXGvqfDhPSBXNvStuBH\n" +
                "66484.8:gals:SKwgpsM\n" +
                "8382.8:pints:sXRbRzspDrZoMKhHXCZaCcaWoIAudYo\n" +
                "124928.4:fl ozs:KmwfMVTwSeRbHCuMo\n" +
                "69556.8:pts:FJNzsoRlfzknTnToZ bkQOvOkrMXudAkCpiuGkLmZnA\n" +
                "115320.3:ls:NEShyOstM vAfIxeqAxDJWAUMs mtFqTKyifgtGMnE\n" +
                "28050.2:ls:CrxlHUInMarCtpHtNQPiSjWqLvnEKyOQfLiy\n" +
                "40231.1:tablespoons:skOXNQoMLqgDnJxdRBykBeaHCA pRhtoS YgFKKyvmkmYaQE\n" +
                "39186.9:pints:wTnOVS\n" +
                "25529.2:gals:BQC KacHM GipStTy l\n" +
                "105150.9:cups:iheAPNTFNLqXnMEOwQNF\n" +
                "15394.8:pts:YxVJwASzjfnlwwMhwmUvhyF OpaPSTHcSP wCETJ\n" +
                "46652:qts:lIUkgyiCzAWzFNPAQRTraMZUGNNqfqpREx JjLjBtsP\n" +
                "39901.8:fluid ounces:LuNhDHdgTQX\n" +
                "279.2:gallons:WjQyKJLnjWxmSzQAvHYQoXcNvDgmpWL\n" +
                "18855.1:ls:ZFfqZscmbnvu\n" +
                "55040.1:pints:Za LIVCiaUwkxomfzUGgcKx\n" +
                "121571.8:qts:OfaxtqqXroyAyybwzEXjLOPEWhXgfwXviAaxGpyBEALkB\n" +
                "120021.8:pts:ZfdZauUiMaagla\n" +
                "37490.5:gallons:xSkFeK\n" +
                "85574.9:fluid ounces:MtYUdegiOTHolWXk\n" +
                "69179.2:gals:EZ\n" +
                "3083:gallons:CJFIGOgFAfmaCUMfFpCQJkQB\n" +
                "81786.7:tsps:ieMBnJVUkrReRdoURTntwTjCgASnlkOKVVuoEfH zAiWfC\n" +
                "113437.4:mls:qKeymuWjNczc vNzDTtvg nHdCplAxGhkDygLKF\n" +
                "16975.2:gallons:c\n" +
                "23715.3:mls:BaijMisrQJTIF OTZCXgAHWyz\n" +
                "34678.8:pts:ULYmcC\n" +
                "23391.4:liters:jbAuLriVtUzMjReGMFZhOSwdjwdNRV yRvjXfIDNEXBBmi\n" +
                "123919.9:qts:iNXhBQRtndcSXCnYzyoGylcYkWe  PGxYCjnmBSWGdmIk\n" +
                "111842.9:tsps:ejvM ZmdVlqvLeCQzs\n" +
                "2448.5:tablespoons:COZHpjDlbpAtYzYNlNuUQGPbrEbbMwwlS\n" +
                "119540.6:pints:xOdxmh\n" +
                "70793.2:tbsps:CijxEBpXnGAnmCbhDVYwtAiJtlYllMtkjsDkzOyqdSmPMYISk\n" +
                "50771.3:gals:tTtbYJitwuMNAYIyxlSWxbvtHaGKJaNqHkCPavVJSvMA O\n" +
                "62146.4:qts:eehbGDbtWDEkdCoufmuiVpwtyjaRzYWDnIK\n" +
                "105036:pts:ozUoFSwNeqnPq XSaWhRXpNPKUzmBmAv\n" +
                "71865.3:liters:kyZKoJlOB\n" +
                "98335.8:tablespoons:tJ\n" +
                "64365.5:tbsps:ETrmhUzmZOTuX\n" +
                "10668.5:milliliters:QFCKwHzOwZkaEiHvBY\n" +
                "1905.6:milliliters:nJPoQKCMRggEkJspOlDqDc\n" +
                "37074.4:fluid ounces:OMmNDfB\n" +
                "27420.6:milliliters:UoWFFlmkLyPTaETAuuenwGQjaGKuKCkRLvWpeYsvWMvy\n" +
                "24056.5:gallons:zfgk\n" +
                "99143.6:tablespoons:pIrh\n" +
                "71761.3:cups:LWFravZtOLdWcuuyNDfnAnEmkpkNmDDzOxuyCsucXskkCPoyd\n" +
                "12573.1:qts:b rikFChXnPXyuDaqMbCkomQSNwZm\n" +
                "105340.3:mls:JswIruKJVfaLjo tprfKYQXGXb\n" +
                "120159.1:cups:BaijMisrQJTIF OTZCXgAHWyz\n" +
                "64400.1:tsps:zjYgJIyRmJXjvPHblPHHNbIZ Cyn\n" +
                "101675.7:tbsps:EPbdhPxCBATCGcPVhgyBvuVY\n" +
                "79814.1:tbsps:yhgJXior\n" +
                "43316.6:tablespoons:RJwTdibbdAIHDuOpLOE\n" +
                "50471.8:tsps:KHJklOdXuBDopWcCjsbkptIcJjvBrMGLY\n" +
                "61888.3:pints:ICScibiqcnSG\n" +
                "2406.3:fluid ounces:PuWjbEcUg\n" +
                "15128.8:fl ozs:nHzXqqQfPhzkgaEaYtML kbheIa BmRHeZdALjiSODRNXXG\n" +
                "60753.6:pts:fTWHu kyEjHFsXKYklrrQJMJvxrICWVlSQu\n" +
                "116463:gallons:hIoxBeQMWkKvTqDh\n" +
                "64120.4:ls:UCPHe QXkClBPfVOcHJ  XbNLLoyFe CJaR\n" +
                "5390.8:pts:OojaTlAPTYrYcTi XeBmkFxKb\n" +
                "98539.8:quarts:NxNzMJXMcNuBwRrjarFTIP\n" +
                "117950.6:teaspoons:YBIoGcPOBdkdXHLtwyHZOcQqFOGAYYnsZKwtDTUlVOm\n" +
                "118926:fluid ounces:Tz dPUhWsmgFMsDw\n" +
                "78299.3:fluid ounces:UgdAn dZXguxPSDYgktkfbf mkHzHzKc\n" +
                "86713.9:fl ozs:UTPiULiQkZrskrGIEhDrRNNOEMBaBajoSPtSfUIHXWOltrgz\n" +
                "59533.1:gals:lLYUTYViPQHwypOsCxjkYMbptdEnLPCDjERzXhYqVCPPASSf\n" +
                "86442:milliliters:FUPjTXIZknkyWRBET UwhnmWjBUHowMACMsqwhySbMzimTLL\n" +
                "50769.4:fluid ounces:hWJfjrqiTqxWqPygKFDKInlMemxakjJAGTIrzkwChqJO\n" +
                "26330.2:fluid ounces:HDJ\n" +
                "73343.5:tsps:usOYTa nNAbCCwyWzs\n" +
                "65269.2:gallons:NsSpP\n" +
                "113352.8:gals:ONMNToCDSST\n" +
                "43055.9:tablespoons:usOYTa nNAbCCwyWzs\n" +
                "6946.9:gallons:WJK ixvSiQvELdhmnaeZsJhGGWEmMhbr KkSNgKSfvntaKEfe\n" +
                "23369.8:quarts:PgVWARVrDuRtjPsgHSFjPECKuKMaCBLiSIRqtW\n" +
                "44010.5:milliliters:qZukthUhDWfxHhmKRBlgL\n" +
                "62797.4:gallons:hfWaaCJrumLCGbZzDQuuKBiE\n" +
                "51955.9:liters:QeNsaljKlYRTVsWrjVpHopcuSTVlv\n" +
                "29688.3:mls:hVCZQqu\n" +
                "80767.9:tablespoons:vqaudgLc unElCxXDFKKErBGwbgZ\n" +
                "32741.4:ls:BWFxsoTBDRpvoP BCnzPlTwnMePsPnfDEFsgLvhDVtOmNTQ\n" +
                "78016.3:liters:xTxelNqFxZHRmDCgRiieyYpMPbtDLakgBrdMtJ\n" +
                "76673.5:mls:QrBseDTjW\n" +
                "116740.6:pints:pHInb\n" +
                "50057.8:gallons:rErNKiVBNcUeilsThdCrqIngN\n" +
                "98411.6:tsps:Ez fDWOHkeiaOsFXMuIUWgUwfsmdGivVLgOlqMw\n" +
                "26035.3:ls:HkBNNAwZiZWbxBTRWgvpuZAOrOLEGrPmjpEaL\n" +
                "49187.3:ls:jbGbkSWsviSU mbYvFrfqNICEJT\n" +
                "58994.5:qts:b\n" +
                "75845.9:tablespoons:L wiSQRCEGGGVmmdKSrVynSjelfoZCrAvvQRIvasfIgcud\n" +
                "118969.5:mls:EQrlTDselCsMvlILHunz ex\n" +
                "48884.2:mls:WuVYBwoGcBjhwXhIlLerAyPH\n" +
                "39910.8:qts:PYpEpyRrmrCKAUApzfFqppo\n" +
                "118973.8:quarts:dbU\n" +
                "23009.6:ls:dixaUMPGvVEsuiySvEWLtlamYXTqmMePYVoEsqXgCjsP\n" +
                "65864.9:gals:QOwJCgOBTcv\n" +
                "10680.6:quarts:hV KHwDaftgKDcghzVPQaTStGqNHSQHUDzsULpgfgInA\n" +
                "72990.8:teaspoons:Zz\n" +
                "122376.5:gallons:PrGiAZMpIAgHlOupOHcTonRnjwT\n" +
                "74639.8:milliliters:vUpihRafUKOlALPkEJnvZyrbkIuMywzLnqPLKeUFXb\n" +
                "40888:cups:ieGgKRKNx\n" +
                "39525.7:tbsps:oZVzAQPmdWQZfdXsrVYLBWUMvXuo\n" +
                "65462.4:ls:OnJeqCMcQS x ZBaMlmxSlY gaOeVVGZtdaTJYPVKpFxLad\n" +
                "52448.5:gallons:RelvtLaYelhMnKPyiuqZHYsbTwT\n" +
                "89043.7:pts:naUaUn\n" +
                "2214:teaspoons:QwLFvWYIPOycfESceyGlptPHH NGmnDaUTwTPbn\n" +
                "111498.7:fluid ounces:PBXxMLINknOifGE DTvJtOhi\n" +
                "36678.8:tbsps:nXetEEWZH\n" +
                "20207.1:tsps:SZThPeMLEXEKIktmEXnRBYgPTxfeIvjsrFNRboSJsZ\n" +
                "58534.2:milliliters:UVHfLU\n" +
                "65583.6:gals:GhxcxGMtHJuyLDnVNXHfFhEMTwIZlQjhYOEVXZYU u\n" +
                "94707.3:liters:W\n" +
                "41691.5:quarts:NriidudshmBBBvUTLloOfkoKYLyMAeJr UNj\n" +
                "58920.9:fl ozs:vUpihRafUKOlALPkEJnvZyrbkIuMywzLnqPLKeUFXb\n" +
                "109163.7:tablespoons:YNsWsPAbgBSWPIsAopOiv ADopkKyRBWypSB\n" +
                "63324.7:cups:jgLhuNmBCAykkfRxKjwVtoMwnYZvKJ\n" +
                "94318.2:tsps:SqohyzsthKklhkiDhFaVVvjcpjcvJuaLJoLokHYUgkkJSLlZ\n" +
                "95547:pts:AVST\n" +
                "113301.6:tsps:NYzWxKzkYezsYYqukajMxFDtONtl\n" +
                "112308.6:fluid ounces:ddCOQkGFnUratCUBebCLeJ\n" +
                "21633.8:pints:Tz dPUhWsmgFMsDw\n" +
                "114638.4:pints:uQuxxxZ\n" +
                "30714.7:quarts:lIUkgyiCzAWzFNPAQRTraMZUGNNqfqpREx JjLjBtsP\n" +
                "48473.3:pints:HhIfWnIvrpihoxJU\n" +
                "116203.9:mls:WJyeNsLnlRurLcedAuEKVYTlwyEvQJfbiLELR\n" +
                "10690.7:cups:vKtjTCbikkf YlQ\n" +
                "29612.3:gallons:mRuzYWocopfoGfqSq\n" +
                "9884.4:fluid ounces:LSzeWXVszNZPnA T\n" +
                "33274.9:ls:LDzBnnyRGYfjRgJSYbGVyJgn\n" +
                "25439.3:tablespoons:ryLXpNMQujLQoczHjCuzXjtNNBMRA qkOAlSRyq\n" +
                "30847.1:pints:eyzAlQ\n" +
                "121493:quarts:IIaCgjVIZqMmMTVLnxDoYNxCUnQwfuvIVIPRhuZur\n" +
                "51058.5:cups:PmIOWZnnVtwVd\n" +
                "29545.7:qts:EvgvhknzdpUpAOsockAyjRBvvsQMRvNSVGWVLkNlBa  ZyoI\n" +
                "68695.3:gals:ZFfqZscmbnvu\n" +
                "39682.8:milliliters:ciJEWvxfzdsr PgNeL XevHsA\n" +
                "33165.2:milliliters:rVRXgAYVniLpwXNyoSSNEsHjIQvGQjCLlEC\n" +
                "78729.1:pints:pxqRreLrBzuUmwBGCsZU\n" +
                "14760.8:fluid ounces:XDZbIPiYASf\n" +
                "18321:mls:sqHwNNzWdItld\n" +
                "91100.2:teaspoons:cg NEtbHAZIkQwuPqKSLVdTiMRhznNGyywXofJN\n" +
                "5099.3:tbsps:LMEsS\n" +
                "78528.3:milliliters:koqEpjZUTPjshtCctvZDVeIbLITudGxLb\n" +
                "124252.9:teaspoons:Dx iePMSLZPuAHHAcu\n" +
                "10566.1:ls:b\n" +
                "72420.9:liters:rgoqqsQHAhdZLHAEAzdBGsuJzQJIlBGmoJdRyb\n" +
                "21704.9:mls:VseNJyZrxFknZOvTnVSlRcrHrQBiyDsBeDlaJjDdzP\n" +
                "91566.4:gals:MFBcvKjbCjatoZ\n" +
                "122182.1:tablespoons:RLktZjBkXWYzxYyvvE\n" +
                "26729.2:qts:swbRHhOytyZJOMFyMjBtW\n" +
                "75762:tsps:tPDNfKCSxXZmzM\n" +
                "79538.9:mls:nxLkWi yQDWMOoYSOnJIRzejaN\n" +
                "101679.9:tsps:eAbSBxzDmwAOmIexSPdeIqANtTEGuaWBm\n" +
                "3500.5:tsps:lHBWLPUKHCXCfNEs\n" +
                "20272.7:gallons:b rikFChXnPXyuDaqMbCkomQSNwZm\n" +
                "18704.7:teaspoons:RKUfcGOmQoHkRShxXpbdPxBt\n" +
                "13164:pts:LNxNJyfcALvS  GpuCyffZJuJQmQOc\n" +
                "124341.2:fl ozs:McaLZPxsYXp DhihNMgTCtAWXDmU\n" +
                "26134.9:pts:ZqHSbxBLJKMUNOmtgnYCawvSIUj\n" +
                "9136.2:tbsps:hcTHRRQnI\n" +
                "59453.2:fluid ounces:YNXCBRZjwTYW CKtmbkmCI hncUhizLhZ\n" +
                "114752.8:tbsps:iQ n WZsYOZNFmOKTJIfzCRTQYDfunQXWMmAuG\n" +
                "19827.9:ls:BpBYDiF\n" +
                "21937.7:fluid ounces:CijxEBpXnGAnmCbhDVYwtAiJtlYllMtkjsDkzOyqdSmPMYISk\n" +
                "15152.3:tablespoons:IgBebmBQrTQbbFKydmSRnStHyo lTehmmFPXSO\n" +
                "6061.3:milliliters:ofpEGjqKRBHWx QPIrddy\n" +
                "110815.8:pts:urZOXeUhfnVXKTiYN\n" +
                "14056.7:tbsps:JbbfJW\n" +
                "79977.5:mls:nkUXrkwrtGBfdMoQm\n" +
                "75390.4:milliliters:JscTukaScZWRakRViXThmhw qTVsCcXaEKpAksrxetYTTcwj\n" +
                "14333.4:fluid ounces:SKwgpsM\n" +
                "87710.5:ls:PuzUTAeHPijSkShYwgjDnHPNvwhpaneOJZDxACrA\n" +
                "96653.6:milliliters:JpeuCHElHJoCBTrQAyuF\n" +
                "91084.1:gals:hCLvTtFLkKFRmSbjUaDhUTcCKzWgnThAcqZjA ZueET\n" +
                "21008.6:tbsps:vhXlFlOmWqil\n" +
                "67967.3:qts:QDtMjLuWZ\n" +
                "55333.7:gallons:YHI\n" +
                "54639.4:ls:KPBcEvvJO\n" +
                "56553.3:milliliters:zMjFZRZIeGtQbkKYPPyyJSvgtLJPSK BAjBeG\n" +
                "98586.1:mls:Xpv\n" +
                "15773.3:qts:xsKoZGsWOjECoxPfEUkc\n" +
                "122709.6:tablespoons:zDrSgAVXzRdiPHokhzlugMwEUNamrvXoOwedntBisFccnILQ\n" +
                "71914:tablespoons:OMYM MWuruZhgZVcny\n" +
                "123082.4:pints:GPH\n" +
                "97940.5:mls:ikbcLvuiRHaBciIcnVOF j ISPpvxrIzeVrHhsA\n" +
                "121818.9:gallons:CJFIGOgFAfmaCUMfFpCQJkQB\n" +
                "67793.6:tsps:nXetEEWZH\n" +
                "57709.8:quarts:HNHXzTrdGmfV BvajmYMTiwPl eQyVJLAuikn\n" +
                "10671.5:milliliters:KPBcEvvJO\n" +
                "26239.5:fl ozs:bH ZFOGqRMDTjIoWq\n" +
                "121121.3:tsps:ZVaBAvylUJErtnjetvHGEx\n" +
                "13351.1:cups:hIoxBeQMWkKvTqDh\n" +
                "9513:ls:jlZqBoYADLyFv\n" +
                "93401.7:gallons:zMjFZRZIeGtQbkKYPPyyJSvgtLJPSK BAjBeG\n" +
                "29254.6:ls:oYOwCAZcOZOlnWdROJdvPLBVrrpRvsyUfuiYCPRxQPm\n" +
                "12466.3:gals:mcCHyVJVYNJFsjGOVoyUNPuyYLvQJNapJnUDSjxwu\n" +
                "49838.7:tablespoons:CvMtkMvygJG\n" +
                "15895:ls:dZMCxpwYHvvIXpDJwswCrerYhdcgDzX\n" +
                "4838.4:tsps:dZAnjNeZArLJsQEXEgDfHSCBbwLarzHogtGvUmpC\n" +
                "94292.5:liters:Z SNtjAXeRjKvOYaM\n" +
                "58973.7:liters:CtKRxileTingsfHrYHXLHOvqDmikAeEcZjiQRAVGciYkkEAcx\n" +
                "50506.3:teaspoons:smWFygmqXVmlOhrrzEKpkuMUxOAqU PNhwPRA\n" +
                "45029.4:milliliters:ADgL MfwlTndherIVioLmhfJ\n" +
                "50161.6:fl ozs:b\n" +
                "38717.2:quarts:ZzsgFydxlpTXNppyUnamiIfsCYdkbII\n" +
                "35484.7:teaspoons:RYTmOLHqcJcURO\n" +
                "47664.4:pts:UgdAn dZXguxPSDYgktkfbf mkHzHzKc\n" +
                "65634.8:tablespoons:YPtaWcVxzQfigM\n" +
                "96302.5:qts:mVIPM\n" +
                "97979.4:quarts:KuFcQXIrVmnRuBTiv DzXwHQqQzUZJPcjWq\n" +
                "5058.5:gals:MioiSSx\n" +
                "60711.3:milliliters:qgXZNAWNOLZBcrwaRIBYTeKKESvdFUygXHzMbDjFDTh\n" +
                "35462.7:pints:ikbcLvuiRHaBciIcnVOF j ISPpvxrIzeVrHhsA\n" +
                "74326.1:ls:UJpUZJCOEG\n" +
                "59168:cups:RZxkcjRhjhSilbWTzvH\n" +
                "82599.2:fl ozs:ZUuq ByaoygQzjNvEP yBKsiLFw\n" +
                "6808.2:ls:DM leQpyQWMxZybMPCVjCpliOja\n" +
                "86575.3:ls:IyOjDkPCnPFWAYQgugOWWOfrMP dqXtUZ Kmxtu\n" +
                "44915.5:gals:EfeqnNcjjZpv\n" +
                "49861.5:fl ozs:qn DF\n" +
                "69065:teaspoons:uFyVP pCNsAvmSiTUuJQRZWCYIETxw\n" +
                "77173.2:pints:MSnoovtzR kJKQfFv sXFoUvxEhCGS\n" +
                "58488.4:fl ozs:GqIdCbOzEYYOHsK hdOreiWFgoFabL\n" +
                "65578.3:fluid ounces:kyZKoJlOB\n" +
                "32515.3:liters:rgoqqsQHAhdZLHAEAzdBGsuJzQJIlBGmoJdRyb\n" +
                "5885.7:milliliters:pHInb\n" +
                "23994.8:qts:rFKZARMzVqeO\n" +
                "35874.5:tablespoons:JgWmsJHsQxejZteKcWrCejYYzsoJddAjmN tuaRlpZuZnjHi\n" +
                "62639.2:mls:BrpWsXtKNGFgmAZewFztciMNdXSEoRhekHIZuZPHIzorbNtM\n" +
                "47427.8:cups:lLYUTYViPQHwypOsCxjkYMbptdEnLPCDjERzXhYqVCPPASSf\n" +
                "6104.8:mls:tTtbYJitwuMNAYIyxlSWxbvtHaGKJaNqHkCPavVJSvMA O\n" +
                "33555.5:tsps:AGDXsppdqiXUykWMRVDZoIcBsuIgg\n" +
                "46032.7:teaspoons:JOTbKZPkqxECCHDCyRyT tB\n" +
                "342.7:pints:dFYVkqkjsVGJPvBobwmjeH\n" +
                "116436.6:cups:T\n" +
                "4901.3:quarts:VseNJyZrxFknZOvTnVSlRcrHrQBiyDsBeDlaJjDdzP\n" +
                "83064.6:fl ozs:ieMBnJVUkrReRdoURTntwTjCgASnlkOKVVuoEfH zAiWfC\n" +
                "92550.2:gals:CJUKGhhhIeKXzqyhwrFogpdUoMUuguftvx\n" +
                "18686.2:fluid ounces:eaNNOuatA\n" +
                "36917.7:gallons:kwfkBHbLRh muKtPPaFCRwGCTpHv\n" +
                "78493.5:tablespoons:IiOdyxTUIB UJxykMVfveYEvEhdQGYjHge\n" +
                "23874.7:pts:bcwTtjOqAuJEzvBfZZLSJpwJgkgt gUtvvmYKglpVLkICb\n" +
                "25162.5:tbsps:hWap iNWWYEJMnMgIuHEEuBwinSRlpV\n" +
                "10381.4:quarts:ziEJGVx\n" +
                "22149.7:tsps:VfCpLVkx\n" +
                "3876.6:gals:IEWy\n" +
                "69827.4:tsps:KBMTqIsYgeeKoIAQvVgAdFqxltGVrEQtlCwVTGyGIQL\n" +
                "45302.2:gals:rlJEwAaQIafjzWN KVAocrStbJmM\n" +
                "54217.3:qts:SDhwx\n" +
                "84043.9:pts:aMSBbCMhEPrgZgSozrquIy\n" +
                "39508.2:qts:epboPTpMMnPiQeYvgpgagj\n" +
                "77953.8:quarts:COZHpjDlbpAtYzYNlNuUQGPbrEbbMwwlS\n" +
                "36962:tbsps:wEkdFcJ\n" +
                "79910.9:tablespoons:PuzUTAeHPijSkShYwgjDnHPNvwhpaneOJZDxACrA\n" +
                "105212.8:ls:bEXcJUrRSygDsHGryQdgIiRDFVkwUPAYmWsRan\n" +
                "87399.7:pints:VF\n" +
                "75908.1:tablespoons:dbU\n" +
                "80937.4:gals:NEShyOstM vAfIxeqAxDJWAUMs mtFqTKyifgtGMnE\n" +
                "12197.1:pts:lONMwymP lH\n" +
                "110443.9:liters:kwfkBHbLRh muKtPPaFCRwGCTpHv\n" +
                "54686.2:teaspoons:xuUhkFFozsuyhTCPySaueUKtCxsLZibRhDzXprDIdagEEPl\n" +
                "121006.5:gallons:YVkAqpUVPDfEewhsOXoAzgTTSYysMraNca\n" +
                "57011.5:pints:tzqYKGjoHIF\n" +
                "101542.1:qts:L\n" +
                "18185:pints:zSID ETJGuKTfuGxzcdiD hxvjfTCpSRaJcTIi\n" +
                "59322.7:pints:aluSYRfhqmSzBNtqUgRnuz\n" +
                "22589.2:teaspoons:SZThPeMLEXEKIktmEXnRBYgPTxfeIvjsrFNRboSJsZ\n" +
                "82519.9:quarts:AeaMI sKoyALrMLPHytQifVUSfkzSn\n" +
                "108317.8:tablespoons:ozUoFSwNeqnPq XSaWhRXpNPKUzmBmAv\n" +
                "10664.6:mls:STlSILYQyEvUsrbkISxfvGl lpzzrtimikeQaLyQr\n" +
                "91352.9:tbsps:mxIAnGmiNvuJhLtxxAkibxuIMbHsNLiAqUQOPgGV\n" +
                "110837.2:cups:GhxcxGMtHJuyLDnVNXHfFhEMTwIZlQjhYOEVXZYU u\n" +
                "71009.9:mls:QAWhTdfimYdrbbStgYJGtsZG btAFHVRpwgAFczYfgh\n" +
                "3438.9:qts:icxgmRpwXJMJyASyUu GgPL\n" +
                "25411.7:tablespoons:EGmd\n" +
                "36877:liters:gOagATp\n" +
                "3796.9:qts:mnmnVEElLlBcLwVuFKtNaGIcwCD\n" +
                "30017.6:quarts:pIrh\n" +
                "52765.2:tablespoons:VfvMPgTYVOkZfOF\n" +
                "109030.5:ls:dDiFVOsTdg uBgEdWNezXzclLdAfivOqEeyqbM\n" +
                "33713.2:tbsps:Ofc\n" +
                "88145.1:tablespoons:mQhquAwOCHLRSUzcyaNdDgLLsZt\n" +
                "78971.2:mls:vCVzKvCnqDOUyeBtdYBDZuksNxcjiSDxvZhl\n" +
                "39379:quarts:teyRhcjUGOjiuYnMdtAWZx MJhBzfCDUPHdBEgNgjC\n" +
                "39869.7:pts:Uc\n" +
                "91949.2:fluid ounces:vjjtLJsTFxNKGmbvZCSuPLqkCFpZ\n" +
                "77164.9:milliliters:jPZjbmuUkDNiFHcjehGwRVsewlRVVyiWyRGNz\n" +
                "64850.9:teaspoons:TwDOUTJvQqHCufKlJKOUgsqARpMyZFEzEqn\n" +
                "45556:gals:uQuxxxZ\n" +
                "120064.7:quarts:kxlZxGog HMeTeBSiTx\n" +
                "105637.4:ls:ueuQVPgjmfgY\n" +
                "89507.8:qts:ejVNoMVcDtfMYlJIqQfbyVUc\n" +
                "122765.5:gallons:xuUhkFFozsuyhTCPySaueUKtCxsLZibRhDzXprDIdagEEPl\n" +
                "7498.4:quarts:TOGUctXOZIZKewpU\n" +
                "12482.2:milliliters:maBCHuqVqMIeYlWXIQujwoVJuXZBWqZOAHBejDIjbA YDrH\n" +
                "12218.8:quarts:SDhwx\n" +
                "66410.5:fl ozs:KjCu\n" +
                "24212.9:mls:uTGUEiQuioArLhaoSZUfLBGbbgCRUgQxbBOhQxGByd\n" +
                "116484:fl ozs:gPzHTypquKnxX\n" +
                "15556.8:mls:rvaZWKXYaHllWmGuhNVREPZj\n" +
                "76733.2:pints:GyfohBhqaOyiU\n" +
                "36633.4:qts:bviavUgmiEUwOShoedDSY tizLshToiLYykoCGYtsoWRoqt\n" +
                "109365.4:tsps:VLvnqteCgbKNyeky\n" +
                "77388.1:liters:jlZqBoYADLyFv\n" +
                "69593:cups:JlCYjEieSJKrcRzGaWn\n" +
                "115413.5:gals:iMXtAIFeUOttDkXNXdb JurlbjgVBK SDsVAv\n" +
                "23320.7:mls:GPH\n" +
                "19959:fl ozs:G\n" +
                "13000.3:qts:MDtVYCh\n" +
                "30269.9:ls:UoVlCzut VQPEyTYms\n" +
                "69562:tablespoons:kvNcWUHXAUZhNkdawjqId\n" +
                "15323.2:teaspoons:faJdilXpqE GSKxLtMNIdUH\n" +
                "56129.1:cups:fkwANYyfEbKdFghDMhbKWMvVf NDJuPOYQOibDX\n" +
                "63228.4:milliliters:HgQBGCxnZaaPBQABlFlxRecpPonszpuX MsMupizDJmuI\n" +
                "19279.8:mls:zKavthFCAjWGOfsqygoDSsyhIzuwGRoCGLEkm\n" +
                "45216.4:gals:HFyLlPtYXCczqYw\n" +
                "77712.7:pts:N\n" +
                "122029.3:mls:fidCwAL HzGsWvbTcD\n" +
                "2666.2:tbsps:RLktZjBkXWYzxYyvvE\n" +
                "2019.5:milliliters:edXQkyGHfuUtuCQB PmIJUzkIDPDz\n" +
                "96219.6:qts:acFsdmoijQuhQqSHGsB mEpCPYQWSzeyCLAgWMDbb\n" +
                "48561.2:qts:krfRMCIRSEKuYPIrpqcxWqTJLqO\n" +
                "100164.2:gals:QQWMPrGNZTOIFUePJ DYxDOcFHRUFa\n" +
                "114535.7:tbsps:UzNGTxf pUkwL\n" +
                "11773.6:pints:OWTfhjDlhRHEeCxNMUqRFaZXgCzQXuKYlwXStly\n" +
                "31401.4:tablespoons:BnFl cjfVOLWDOixWewHQXpnw\n" +
                "105623.8:fluid ounces:crynNIdEP\n" +
                "92914.5:tablespoons:tTXxtleChDKzxuOGCevjloJySOIzerPQwyOwdPKCFxwTPeTh\n" +
                "84369.9:qts:IrNhigLwoCjAGhKzieEdYaDRVOSjscx\n" +
                "10425.8:gals:ZfdZauUiMaagla\n" +
                "93747.1:cups:Ofc\n" +
                "53359.3:pints:ieMBnJVUkrReRdoURTntwTjCgASnlkOKVVuoEfH zAiWfC\n" +
                "62448.2:pints:zSID ETJGuKTfuGxzcdiD hxvjfTCpSRaJcTIi\n" +
                "4657.5:gallons:IgBebmBQrTQbbFKydmSRnStHyo lTehmmFPXSO\n" +
                "73297.7:tsps:hpvYjOCbFbMArCRqB\n" +
                "89973.5:fl ozs:NYzWxKzkYezsYYqukajMxFDtONtl\n" +
                "3767.8:milliliters:E\n" +
                "90620.2:ls:ifak\n" +
                "100512.2:ls:rKkAdhK\n" +
                "5384.6:tablespoons:ToOKclb\n" +
                "122002.1:fluid ounces:qgKYRIzVksukjhWHEbgYbCUP\n" +
                "14910.7:mls:FeBZghXwFfIJrulXaydHNUBuEWtXWkuTRmyxLVUUzPR\n" +
                "124304.2:tablespoons:MoGzqQuKrPortXsSZGIxhHJcIFKkdPJJwfkTvHgirSh\n" +
                "56726.3:cups:mrAuTFnDaaaXKlEgCppcwMgmVupTwOR\n" +
                "83435.7:milliliters:mXnFizNbhUfckIXp\n" +
                "101454.8:tsps:UvcLqwnXeCeBMtpfNKGdpOzNhVxMTiSHFRtSqMYXJBIOISCP\n" +
                "30167.4:gals:acloXBfLmiFFiPFdkQkPjnKphkKXA\n" +
                "82828.7:pts:AyEAqSFVwPzCPTNPxJRzJIC\n" +
                "67895.6:mls:EjbtiysSwROsisSJOsEANC\n" +
                "21366.7:milliliters:LygwYMHrIfwlGYSIoTbMxKbLYYnPLXAimRUzPNpRKwo\n" +
                "72219.3:quarts:pIrh\n" +
                "45902.8:tablespoons:WBHzxdDvMOwrol\n" +
                "108736.9:gallons:OMYM MWuruZhgZVcny\n" +
                "61611.2:fl ozs:UBoouQZ geUoRMDLEpnTSqUzDEWhAUp\n" +
                "39060.5:tsps:II\n" +
                "26134.5:tablespoons:MSnoovtzR kJKQfFv sXFoUvxEhCGS\n" +
                "33117.4:liters:vvxgyDNxHbNgpFytnmtWDeIfbZkLoBkPPbza\n" +
                "12158.3:gallons:MgxJtuhh\n" +
                "98016.5:quarts:LuqS\n" +
                "220.9:pts:CvooxQKcIatYQtTuYo CnGawTmMboYrCcxVLidiywn\n" +
                "97460.8:teaspoons:MSnoovtzR kJKQfFv sXFoUvxEhCGS\n" +
                "29379.7:tablespoons:RpiKVsdRgCRL\n" +
                "23433.4:mls:lphYPIzj yZvlsAiEhcrsrmGcos\n" +
                "42418:quarts:qnOLpMJmkIOApjVD bHC\n" +
                "46991.8:pts:FUPjTXIZknkyWRBET UwhnmWjBUHowMACMsqwhySbMzimTLL\n" +
                "60435.3:tsps:QUrEHGl cjFH\n" +
                "39080.7:fluid ounces:ByUaESstMGOapfAgOpWbphJtTlSKQ\n";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}