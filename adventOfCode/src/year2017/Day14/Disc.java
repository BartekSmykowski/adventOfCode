package year2017.Day14;

import year2017.Day10.KnotHash;

import java.util.ArrayList;
import java.util.List;

public class Disc {

    private List<List<Boolean>> disc;
    private String key;
    private List<List<Boolean>> inRegions;
    private int numberOfRegions;

    public Disc(String key){

        this.key = key;
        numberOfRegions = 0;

        initDisc();
        markRegions();
    }

    private void markRegions() {
        for(int i = 0; i < disc.size(); i++){
            for(int j = 0; j < disc.get(i).size();j++){
                if(!inRegions.get(i).get(j) && disc.get(i).get(j)) {
                    numberOfRegions++;
                    markRegion(i, j);
                }
            }
        }
    }

    private void initDisc() {
        KnotHash knotHash = new KnotHash();
        List<String> hashes = new ArrayList<>();
        for(int i = 0; i < 128; i++){
            String lineKey = key + "-" + i;
            hashes.add(knotHash.knotHash(lineKey));
        }

        disc = new ArrayList<>();
        inRegions = new ArrayList<>();
        for(String hash:hashes){
            DiscLine discLine = new DiscLine(hash);
            disc.add(discLine.getBits());
            List<Boolean> regionLine = new ArrayList<>();
            inRegions.add(regionLine);
            for(int i = 0; i < discLine.getBits().size();i++){
                regionLine.add(false);
            }
        }
    }

    public List<List<Boolean>> getDisc() {
        return disc;
    }

    public List<List<Boolean>> getInRegions() {
        return inRegions;
    }

    private void markRegion(int i, int j){
        if(inRegions.get(i).get(j) || !disc.get(i).get(j))
            return;
        inRegions.get(i).set(j, true);
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                if(inBound(i+x, j+y)
                        && (x != 0 || y != 0)
                        && (x !=-1 || y !=-1)
                        && (x !=-1 || y != 1)
                        && (x != 1 || y !=-1)
                        && (x != 1 || y != 1)){
                    markRegion(i+x,j+y);
                }
            }
        }
    }

//    public int numberOfRegions(){
//        inRegions = new ArrayList<>();
//        int numberOfRegions = 0;
//        for (int i = 0; i < disc.size(); i++){
//            inRegions.add(new ArrayList<>());
//            for (int j = 0; j < disc.get(i).size();j++) {
//                inRegions.get(i).add(false);
//                if(disc.get(i).get(j)) {
//                    inRegions.get(i).set(j, true);
//                    if (!hasNeighbourGroup(i, j, inRegions)){
//                        numberOfRegions++;
//                    }
//                }
//            }
//        }
//        return numberOfRegions;
//    }

//    private boolean hasNeighbourGroup(int i, int j, List<List<Boolean>> inRegions) {
//        boolean hasNeighbourGroup = false;
//        for(int x = -1; x <= 1; x++){
//            for(int y = -1; y <= 1; y++){
//                if(inBound(i+x, j+y)
//                        && (x != 0 || y != 0)
//                        && (x != -1 || y != -1)
//                        && (x != -1 || y != 1)
//                        && (x != 1 || y != -1)
//                        && (x != 1 || y != 1)){
//                    if(inRegions.get(i+x).get(j+y))
//                        hasNeighbourGroup = true;
//                }
//            }
//        }
//        return hasNeighbourGroup;
//    }

    private boolean inBound(int i, int j) {
        return i>=0 && i < inRegions.size() && j >=0 && j < inRegions.get(i).size();
    }

    public int getNumberOfRegions() {
        return numberOfRegions;
    }
}
