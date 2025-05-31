package pack.model;

public class SangpumImpl implements SangpumInter {
    @Override
    public String calcMoney(String name, int su, int dan) {
        return "상품 : " + name + " 의 가격은 " + (su * dan);
    }
}