package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;


public class MyImpl implements MyInter {
    private SangpumInter sangpumInter;
    private String result;


    public void setSangpumInter(SangpumInter sangpumInter) {
        this.sangpumInter = sangpumInter;
    }

    @Override
    public String inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("상품명 입력: ");
        String name = scanner.nextLine();

        System.out.print("수량 입력: ");
        int su = scanner.nextInt();

        System.out.print("단가 입력: ");
        int dan = scanner.nextInt();

        result = sangpumInter.calcMoney(name, su, dan); // 모델의 계산 로직 호출
        return result;
    }

    @Override
    public void showResult() {
        System.out.println(result);
    }
}