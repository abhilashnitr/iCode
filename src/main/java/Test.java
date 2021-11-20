import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.net.www.http.HttpClient;

class Test{

    private HttpClient httpClient;

    public static void main(String[] args) throws IOException {

        String str="abcdfrejjjdk";

        String publicKeyId="-----BEGIN CERTIFICATE-----\n" +
                "MIIE7jCCAtagAwIBAgIIWmFBujLqylAwDQYJKoZIhvcNAQEMBQAwFTETMBEGA1UEAwwKcnNhX2Fw\n" +
                "aWtleTAeFw0xODEwMzAwNDQ3MThaFw0yMzEwMjkwNDQ3MThaMBUxEzARBgNVBAMMCnJzYV9hcGlr\n" +
                "ZXkwggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAwggIKAoICAQCwjBVK1CLppIwsFm7e+Fp85Hk1Mw2n\n" +
                "5Nc/DKT/pWhpJB8OdlpJA9iF23hrxfbXkrBfCkgvV4Ek4fY1byOnkA7hZq4dYTASCAm89oLwWDNm\n" +
                "0OGNh7E6T7/JoNtjtT0Gh8lJTvpUgHFGg3tiYCScAqul+fS6Rc8+5THk3L9zLzme6eqjkzwBx/ZV\n" +
                "XBIZlAwFkVKbfLFg51LiVoOUz6zXD7nAsMyNhKAgybvqulV07eGzafZ1IBgzpcw5qo0PAd1mTqfy\n" +
                "U+CK9hVeNPPspT16qQWd5xa+fa6BEjuGCumVnFLTbSTRAF5h3QAfvMlkpLdejlXJwvTVQ79Zg5C8\n" +
                "Hu/yWB7tOJBncIKue7KSpwn+vkMws79wpAB5mL4tD3kVCDf2Og7wbtt87v5rcazxF7eZFbsADzHV\n" +
                "oSftdkw5S7iXgh82/CHbRXhzPfG8Zd2v1ksW+Bfnn3czEIMGOSJrKfMbyCYtVMihoi0/L6SHA7++\n" +
                "N9aRrQvfK9PeXnlHgf8pErGUdpjnwdV0tu5atSgf/iBuRgVgUL6t6MFbnBsTQUmZYiQRcsqxOVdy\n" +
                "yfp4DOLgFHGJ1D/isgR/ypalIXMmhuK8GdZ7hukEDX2Dc3js8OkPnFLq6Ps4NIGESfbZSeyINoZX\n" +
                "5GGxdgD/GpokKMHr5bsI3TQujCvzuxShPhUArzCs6TgPmwIDAQABo0IwQDAdBgNVHQ4EFgQUyNoW\n" +
                "eeLVSzVybz7gcZnZlj01cv4wHwYDVR0jBBgwFoAUyNoWeeLVSzVybz7gcZnZlj01cv4wDQYJKoZI\n" +
                "hvcNAQEMBQADggIBADuwEh31OI66oSMB6a79Pd6WSqiyD2NBskdRF7st7CRP5vqeH4P/4srNFAqC\n" +
                "9CjsOmXmSpZFckYQ4zgtqnVQBY7jQlCuSHmg8/Lr1qIzRsMvQmhvp6DJ+bEfQgqcJ+a6tR9cH6hD\n" +
                "VahoMZDEpt3J0fIp30z+O7wJ03K6q5Di/rNey6Ac3GoZwlCi8OFCTmwihcn56I+ssxAqzlq53hzO\n" +
                "iBLLmcMTrWSJWePPkYEhrbBxywg1qJRRGWwkfr1dbRZ22umLHU0R/QdK+jQtqyzghqJpd3T/lHzK\n" +
                "uzAsa0s1R+qMqurKu6mulcLp/XmZpY+Fm4T0WRXzcZBf9trkCSO2Z3VvkCTeGu/WAi3UQpx4HfGr\n" +
                "x02m/h8CHCPPO+PKYthpvSR+0jmiVBaaBo029UG0i2oYBTckng2sy0fx0E+rHnR7pk5Worv8BMm5\n" +
                "sewPUkDDJMZhLtm/bd/VxlI/b56vEA7HvupSWzc7xXV8lZOHVEUAotrlXz+Je2MkEEQIDnYUOYhw\n" +
                "78yFMJJddK9tJVRy8tr8I2j6Zi62jQp/Zltq5JOwpOw/9poovd9wgeRBjuFnscoR/YWrNdPjsjpJ\n" +
                "g/CCb6mthz4R2Mu4enD1YghW7w5darrlUHaYAk+SnwWhMwDwZWWfrVNeEaNq/t/gRm/Ljy+Of3lA\n" +
                "nztA1PrT4bk1KvZX\n" +
                "-----END CERTIFICATE-----";

        String publicKeyPEM = publicKeyId
                .replace("-----BEGIN CERTIFICATE-----", "")
                .replace("\n", "")
                .replace("\r","")
                .replace("-----END CERTIFICATE-----", "");

        System.out.println(publicKeyPEM);
        System.out.println();

//        BASE64Encoder encoder=new BASE64Encoder();
//        BASE64Decoder decoder=new BASE64Decoder();
//        String encode=encoder.encode(publicKeyId.getBytes());
//        System.out.println(encode);
//        byte[] decode=decoder.decodeBuffer(encode);
//
//        System.out.println(new String(decode));
//        for(byte b:decode)
//            System.out.print(b+" ");



//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        long heapSize = Runtime.getRuntime().totalMemory();
//        List<Integer> list = new ArrayList<>();
//        System.out.println("Befpre heap current " + heapSize);
//        for (int i = 0; i < 10000000; i++) {
//            list.add(i);
//            hashMap.put(i, i);
//        }
//        System.out.println("hashMap current  size   " + hashMap.size());
//
//        System.out.println(" Inside : " + Thread.currentThread().getName());
//        System.out.println("creating ExecutorService");
//        ExecutorService executorservice = Executors.newFixedThreadPool(10);
//        System.out.println("creating a runnable");
//        Runnable runnable = () -> {
//            Test t=new Test();
//            System.out.println("inside: "+ Thread.currentThread().getName());
//            t.m1(hashMap);
//        };
//        System.out.println("submit the task specified by the runnable to the executorservice");
//        for(int i=0;i<10;i++){
//            executorservice.submit(runnable);
//
//        }
//
//        heapSize = Runtime.getRuntime().totalMemory();
//        System.out.println("After heap current " + heapSize);
    }


     void m1(HashMap<Integer, Integer> hashMap) {
        //System.out.println("address reference is " + hashMap.hashCode());
        long heapSize = (Runtime.getRuntime().totalMemory());
        System.out.println("current " + heapSize);
        System.out.println(  "hash is" + hashMap);

    }

}