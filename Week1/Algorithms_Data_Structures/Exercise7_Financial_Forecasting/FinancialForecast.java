public class FinancialForecast{
    public static double futureValue(double presentValue,double growthRate,int years){
        if(years==0)return presentValue;
        return(1+growthRate)*futureValue(presentValue,growthRate,years-1);
    }

    public static double futureValueMemo(double presentValue,double growthRate,int years,Double[] memo){
        if(years==0)return presentValue;
        if(memo[years]!=null)return memo[years];
        memo[years]=(1+growthRate)*futureValueMemo(presentValue,growthRate,years-1,memo);
        return memo[years];
    }

    public static void main(String[] args){
        double presentValue=10000;
        double growthRate=0.05;
        int years=10;

        double result=futureValue(presentValue,growthRate,years);
        System.out.printf("Recursive Future Value after %d years: %.2f%n",years,result);

        Double[] memo=new Double[years+1];
        double optimizedResult=futureValueMemo(presentValue,growthRate,years,memo);
        System.out.printf("Memoized Future Value after %d years: %.2f%n",years,optimizedResult);
    }
}
