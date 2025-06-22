import java.util.*;

class Product implements Comparable<Product>{
    int productId;
    String productName;
    String category;

    public Product(int productId,String productName,String category){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
    }

    public int compareTo(Product other){
        return this.productName.toLowerCase().compareTo(other.productName.toLowerCase());
    }

    public String toString(){
        return productId+" - "+productName+" ("+category+")";
    }
}

public class ECommerceSearch{
    public static Product linearSearch(Product[] products,String name){
        name=name.toLowerCase();
        for(Product product:products){
            if(product.productName.toLowerCase().equals(name)){
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products,String name){
        int low=0,high=products.length-1;
        name=name.toLowerCase();
        while(low<=high){
            int mid=(low+high)/2;
            String midName=products[mid].productName.toLowerCase();
            int compare=midName.compareTo(name);
            if(compare==0){
                return products[mid];
            }else if(compare<0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Product[] products={
            new Product(101,"Laptop","Electronics"),
            new Product(102,"Shampoo","Personal Care"),
            new Product(103,"Notebook","Stationery"),
            new Product(104,"Smartphone","Electronics"),
            new Product(105,"Desk","Furniture")
        };

        Product resultLinear=linearSearch(products,"Notebook");
        System.out.println("Linear Search Result: "+(resultLinear!=null?resultLinear:"Product not found"));
        Product[] sortedProducts=Arrays.copyOf(products,products.length);
        Arrays.sort(sortedProducts);

        Product resultBinary=binarySearch(sortedProducts,"Notebook");
        System.out.println("Binary Search Result: "+(resultBinary!=null?resultBinary:"Product not found"));

        System.out.println("\nAnalysis:");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n) [Requires Sorted Data]");
        System.out.println("Recommendation: Use Binary Search for large sorted datasets in production.");
    }
}
