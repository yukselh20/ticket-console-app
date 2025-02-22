package utility;

/**
 * Tüm domain modellerimizin ortak davranışını (ID’ye sahip olma, karşılaştırılabilirlik, doğrulama) belirleyen soyut sınıf.
 */
public abstract class Element implements Comparable<Element>, Validatable {
    public abstract int getId();
}