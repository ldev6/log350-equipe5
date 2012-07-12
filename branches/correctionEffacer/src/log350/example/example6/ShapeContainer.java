
package log350.example.example6;

import java.util.ArrayList;


//FF: fontion ENCADRER, modif 7 {
class ShapeContainer extends  ArrayList< Shape > {

	// public ArrayList< Shape > shapes = new ArrayList< Shape >();

	// Requis à cause de l'interface serializable d'un ArrayList
	private static final long serialVersionUID = -6793181638398923672L;
	// FF: fontion ENCADRER, modif 7 }

	public Shape getShape( int index ) { return this.get(index); }

	public void addShape( ArrayList< Point2D > points /* in world space */ ) {
		Shape s = new Shape( points );
		this.add( s );
	}

	// returns -1 if no shape contains the given point
	public int indexOfShapeContainingGivenPoint( Point2D p /* in world space */ ) {
		for ( int i = 0; i < this.size(); ++i ) {
			Shape s = this.get(i);
			if ( s.contains(p) )
				return i;
		}
		return -1;
	}

	public void draw( GraphicsWrapper gw, int indexOfShapeToHighlight /* -1 for none */ ) {
		for ( int i = 0; i < this.size(); ++i ) {
			Shape s = this.get(i);
			s.draw(gw, i==indexOfShapeToHighlight );
		}
	}

	public AlignedRectangle2D getBoundingRectangle() {
		AlignedRectangle2D rect = new AlignedRectangle2D();
		for ( Shape s : this )
			rect.bound( s.getBoundingRectangle() );
		return rect;
	}
}

