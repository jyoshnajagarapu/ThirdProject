//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//class PaypalTest {
//    public static void main(String[] args){
//
//
////BABAAABABABABBAAABB
//        String seq = "BABB";
//        //int len = getMinLength(seq);
//        //System.out.println(len);
//    }
//    public static List<Integer> getMinLength(List<List<Integer>> locations) {
//
//
//        int[][] points = new int[3][3];
//
//        int i = 0;
//        for (List<Integer> l : locations) {
//            points[i][0] = l.get(0);
//            points[i][1] = l.get(1);
//            i++;
//        }
//
//        // Assuming points are distinct and form a rectangle
//        int[] fourthPoint = new int[2];
//
//        // Find the midpoint between the first two points to determine the diagonal length
//        int midX = (points[0][0] + points[1][0]) / 2;
//        int midY = (points[0][1] + points[1][1]) / 2;
//
//        // Calculate the coordinates of the fourth point
//        fourthPoint[0] = midX + (midY - points[2][1]); // x coordinate
//        fourthPoint[1] = midY - (midX - points[2][0]); // y coordinate
//
//        return Arrays.stream(fourthPoint)
//                .mapToObj(Integer::valueOf)
//                .collect(Collectors.toList());
//
//    }
////        while(seq.contains("AB") || seq.contains("BB")) {
////            if(seq.contains("AB")){
////                seq = seq.replaceAll("AB", "");
////            }
////            if(seq.contains("BB")){
////                seq = seq.replaceAll("BB", "");
////            }
////            //seq = seq.replaceAll("AB", "").replaceAll("BB", "");
////        }
////        return seq.length();
//    }
//}
