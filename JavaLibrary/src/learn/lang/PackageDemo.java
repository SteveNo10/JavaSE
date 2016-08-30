package learn.lang;

public class PackageDemo {
	public static void main(String args[]){
		Package pkgs[];
		pkgs = Package.getPackages();
		for(Package pkg : pkgs){
			System.out.println(pkg.getName() + ";" + pkg.getImplementationTitle() + ";" + pkg.getImplementationVersion() + ";" + pkg.getImplementationVendor());
		}
	}
}
