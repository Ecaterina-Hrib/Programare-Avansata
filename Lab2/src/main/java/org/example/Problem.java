package org.example;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    public void showProblem() {
        Source S1 = new Source("S1", SourceType.FACTORY, 10);
        Source S2 = new Source("S2", SourceType.WAREHOUSE, 35);
        Source S3 = new Source("S3", SourceType.WAREHOUSE, 25);
        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);
        List<Source> sources = new ArrayList<>();
        List<Destination> destinationList = new ArrayList<>();
        sources.add(S1);
        sources.add(S2);
        sources.add(S3);
        destinationList.add(D1);
        destinationList.add(D2);
        destinationList.add(D3);
        Integer[][] costMatrix = new Integer[3][3];
        initMatrix(costMatrix);
        solveExample(costMatrix, sources, destinationList);


    }

    public void initMatrix(Integer[][] costMatrix) {
        costMatrix[0][0] = 2;
        costMatrix[0][1] = 3;
        costMatrix[0][2] = 1;
        costMatrix[1][0] = 5;
        costMatrix[1][1] = 4;
        costMatrix[1][2] = 8;
        costMatrix[2][0] = 5;
        costMatrix[2][1] = 6;
        costMatrix[2][2] = 8;
    }

    public void solveExample(Integer[][] a, List<Source> sources, List<Destination> destination) {
        System.out.println("  " + destination.get(0).getName() + " " + destination.get(1).getName() + " " + destination.get(2).getName() + " Supply");
        for (int i = 0; i <= 2; i++) {
            System.out.print(sources.get(i).getName() + " ");
            for (int j = 0; j <= 2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print(sources.get(i).getCapacity() + " \n");
            if (i == 2) {
                System.out.println("Demand " + destination.get(0).getComodityDemands() + " " + destination.get(1).getComodityDemands() + " " + destination.get(2).getComodityDemands());
            }
        }

    }
}
