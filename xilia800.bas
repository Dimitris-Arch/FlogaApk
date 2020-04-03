B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim sc As ScrollView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label





	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")
    

 simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

 
clv2.AddTextItem("1701  	ΚΑΤΗΓΟΡΙΑ 6.1	Ξυλυλο βρωμιούχο , υγρό	   ", "")
clv2.AddTextItem("1702	ΚΑΤΗΓΟΡΙΑ 6.1	Τετραχλωροαιθάνι	   ", "")
clv2.AddTextItem("1704	ΚΑΤΗΓΟΡΙΑ 6.1	Τετρααιθύλιο Διθειοπυροφωσφορικός	   ", "")
clv2.AddTextItem("1707	ΚΑΤΗΓΟΡΙΑ 6.1	Θάλλιο ενώσεις ", "")
clv2.AddTextItem("1708	ΚΑΤΗΓΟΡΙΑ 6.1	Τολουϊδίνες , υγρό	   ", "")
clv2.AddTextItem("1709	ΚΑΤΗΓΟΡΙΑ 6.1	Τολουυλενοδιαμίνη-τολουολο-διαμίνη	   ", "")
clv2.AddTextItem("1710	ΚΑΤΗΓΟΡΙΑ 6.1	Τριχλωροαιθυλένιο	   ", "")
clv2.AddTextItem("1711	ΚΑΤΗΓΟΡΙΑ 6.1	Ξυλιδίνες , υγρό	   ", "")
clv2.AddTextItem("1712	ΚΑΤΗΓΟΡΙΑ 6.1	Αρσενικικό ψευδαργύρου  ", "")
clv2.AddTextItem("1713	ΚΑΤΗΓΟΡΙΑ 6.1	Κυανιούχου ψευδαργύρου	   ", "")
clv2.AddTextItem("1714	ΚΑΤΗΓΟΡΙΑ 4.3	Φωσφορούχο ψευδαργύρου	   ", "")
clv2.AddTextItem("1715	ΚΑΤΗΓΟΡΙΑ 8	Οξικός ανυδρίτης	   ", "")
clv2.AddTextItem("1716	ΚΑΤΗΓΟΡΙΑ 8	Ακετυλοβρωμίδιο	   ", "")
clv2.AddTextItem("1717	ΚΑΤΗΓΟΡΙΑ 3	Ακετυλοχλωρίδιο	   ", "")
clv2.AddTextItem("1718	ΚΑΤΗΓΟΡΙΑ 8	Βουτυλο φωσφορικό οξύ	   ", "")
clv2.AddTextItem("1719	ΚΑΤΗΓΟΡΙΑ 8	Καυστικό υγρό αλκαλίων, 	   ", "")
clv2.AddTextItem("1722	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροφορμικό αλλύλιο	   ", "")
clv2.AddTextItem("1723	ΚΑΤΗΓΟΡΙΑ 3	Αλλυλοϊωδίδιο	   ", "")
clv2.AddTextItem("1724	ΚΑΤΗΓΟΡΙΑ 8	Allyltrichlorosilane 	   ", "")
clv2.AddTextItem("1725	ΚΑΤΗΓΟΡΙΑ 8	Βρωμιούχο αργίλιο , άνυδρο	   ", "")
clv2.AddTextItem("1726	ΚΑΤΗΓΟΡΙΑ 8	Χλωριούχο αργίλιο , άνυδρο	   ", "")
clv2.AddTextItem("1727	ΚΑΤΗΓΟΡΙΑ 8	Hydrogendifluoride αμμώνιο , στερεό	   ", "")
clv2.AddTextItem("1728	ΚΑΤΗΓΟΡΙΑ 8	Amyltrichlorosilane	   ", "")
clv2.AddTextItem("1729	ΚΑΤΗΓΟΡΙΑ 8	Ανισοϋλ χλωρίδιο	   ", "")
clv2.AddTextItem("1730	ΚΑΤΗΓΟΡΙΑ 8	Πενταχλωριούχο αντιμόνιο , υγρό	   ", "")
clv2.AddTextItem("1731	ΚΑΤΗΓΟΡΙΑ 8	Πενταχλωριούχο αντιμόνιο, διάλυμα	   ", "")
clv2.AddTextItem("1732	ΚΑΤΗΓΟΡΙΑ 8	Πενταφθοριούχο αντιμόνιο	   ", "")
clv2.AddTextItem("1733	ΚΑΤΗΓΟΡΙΑ 8	Τριχλωριούχο αντιμόνιο	   ", "")
clv2.AddTextItem("1736	ΚΑΤΗΓΟΡΙΑ 8	Βενζοϋλοχλωρίδιο	   ", "")
clv2.AddTextItem("1737	ΚΑΤΗΓΟΡΙΑ 6.1	Βενζυλοβρωμιδίου	   ", "")
clv2.AddTextItem("1738	ΚΑΤΗΓΟΡΙΑ 6.1	Βενζυλο χλωριδίου ή βενζυλο χλωρίδιο stabilized	   ", "")
clv2.AddTextItem("1739	ΚΑΤΗΓΟΡΙΑ 8	Χλωρομυρμηκικού βενζυλεστέρα	   ", "")
clv2.AddTextItem("1740	ΚΑΤΗΓΟΡΙΑ 8	Διφθορίδια υδρογόνου ", "")
clv2.AddTextItem("1741	ΚΑΤΗΓΟΡΙΑ 2.3	Τριχλωριούχο βόριο	   ", "")
clv2.AddTextItem("1742	ΚΑΤΗΓΟΡΙΑ 8	Τριφθοριούχου βορίου οξικού οξέος συγκρότημα	   ", "")
clv2.AddTextItem("1743	ΚΑΤΗΓΟΡΙΑ 8	Τριφθοριούχο βόριο προπιονικό οξύ συγκρότημα	   ", "")
clv2.AddTextItem("1744	ΚΑΤΗΓΟΡΙΑ 8	Βρώμιο ή βρώμιο διαλύματα	   ", "")
clv2.AddTextItem("1745	ΚΑΤΗΓΟΡΙΑ 5.1	ΠΕΝΤΑΦΘΟΡΙΟΥΧΟ	   ", "")
clv2.AddTextItem("1746	ΚΑΤΗΓΟΡΙΑ 5.1	Τριφθοριούχο βρώμιο	   ", "")
clv2.AddTextItem("1747	ΚΑΤΗΓΟΡΙΑ 8	Butyltrichlorosilane	   ", "")
clv2.AddTextItem("1748	ΚΑΤΗΓΟΡΙΑ 5.1	Υποχλωριώδες ασβέστιo", "")
clv2.AddTextItem("1749	ΚΑΤΗΓΟΡΙΑ 2.3	Χλώριο τριφθοριούχο	   ", "")
clv2.AddTextItem("1750	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροοξικό οξύ , διάλυμα	   ", "")
clv2.AddTextItem("1751	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροοξικό οξύ, στερεό	   ", "")
clv2.AddTextItem("1752	ΚΑΤΗΓΟΡΙΑ 6.1	Χλωροακετυλοχλωρίδιο	   ", "")
clv2.AddTextItem("1753	ΚΑΤΗΓΟΡΙΑ 8	Chlorophenyltrichlorosilane	   ", "")
clv2.AddTextItem("1754	ΚΑΤΗΓΟΡΙΑ 8	Χλωροσουλφονικό οξύ με ή χωρίς τριοξείδιο  θείου 	", "")   
clv2.AddTextItem("1755	ΚΑΤΗΓΟΡΙΑ 8	Χρωμικό οξύ λύση	   ", "")
clv2.AddTextItem("1756	ΚΑΤΗΓΟΡΙΑ 8	Χρωμικό φθόριο , στερεά	   ", "")
clv2.AddTextItem("1757	ΚΑΤΗΓΟΡΙΑ 8	Χρωμικό φθόριο, λύση	   ", "")
clv2.AddTextItem("1758	ΚΑΤΗΓΟΡΙΑ 8	Οξυχλωριούχου χρωμίου	   ", "")
clv2.AddTextItem("1759	ΚΑΤΗΓΟΡΙΑ 8	Διαβρωτικών στερεών, 	   ", "")
clv2.AddTextItem("1760	ΚΑΤΗΓΟΡΙΑ 8	Διαβρωτικά υγρά, 	   ", "")
clv2.AddTextItem("1761	ΚΑΤΗΓΟΡΙΑ 8	Cupriethylenediamine λύση	   ", "")
clv2.AddTextItem("1762	ΚΑΤΗΓΟΡΙΑ 8	Cyclohexenyltrichlorosilane	   ", "")
clv2.AddTextItem("1763	ΚΑΤΗΓΟΡΙΑ 8	Κυκλοεξυλτριχλωροσιλανίου	   ", "")
clv2.AddTextItem("1764	ΚΑΤΗΓΟΡΙΑ 8	Διχλωροοξεικό οξύ	   ", "")
clv2.AddTextItem("1765	ΚΑΤΗΓΟΡΙΑ 8	Διχλωροακετυλοχλωρίδιο	   ", "")
clv2.AddTextItem("1766	ΚΑΤΗΓΟΡΙΑ 8	Dichlorophenyltrichlorosilane	   ", "")
clv2.AddTextItem("1767	ΚΑΤΗΓΟΡΙΑ 8	Διαιθυλδιχλωροσιλάνιο	   ", "")
clv2.AddTextItem("1768	ΚΑΤΗΓΟΡΙΑ 8	Διφθοροφωσφορικό οξύ , άνυδρο	", "")   
clv2.AddTextItem("1769	ΚΑΤΗΓΟΡΙΑ 8	Diphenyldichlorosilane	   ", "")
clv2.AddTextItem("1770	ΚΑΤΗΓΟΡΙΑ 8	Διφαινυλμεθυλβρωμιδίου	   ", "")
clv2.AddTextItem("1771	ΚΑΤΗΓΟΡΙΑ 8	Dodecyltrichlorosilane	   ", "")
clv2.AddTextItem("1773	ΚΑΤΗΓΟΡΙΑ 8	Χλωριούχου σιδήρου , άνυδρο	   ", "")
clv2.AddTextItem("1774	ΚΑΤΗΓΟΡΙΑ 8	Πυροσβεστήρες , διαβρωτικό υγρό	   ", "")
clv2.AddTextItem("1775	ΚΑΤΗΓΟΡΙΑ 8	Fluoroboric οξύ	   ", "")
clv2.AddTextItem("1776	ΚΑΤΗΓΟΡΙΑ 8	Φθοροφωσφορικό οξύ άνυδρο	   ", "")
clv2.AddTextItem("1777	ΚΑΤΗΓΟΡΙΑ 8	Φθοροσουλφονικό οξύ	   ", "")
clv2.AddTextItem("1778	ΚΑΤΗΓΟΡΙΑ 8	Φθοριοπυριτικό οξύ	   ", "")
clv2.AddTextItem("1779	ΚΑΤΗΓΟΡΙΑ 8	Μυρμηκικό οξύ	   ", "")
clv2.AddTextItem("1780	ΚΑΤΗΓΟΡΙΑ 8	Φουμαρυλο χλωριούχο	   ", "")
clv2.AddTextItem("1781	ΚΑΤΗΓΟΡΙΑ 8	Hexadecyltrichlorosilane	   ", "")
clv2.AddTextItem("1782	ΚΑΤΗΓΟΡΙΑ 8	Εξαφθοροφωσφορικό οξύ	   ", "")
clv2.AddTextItem("1783	ΚΑΤΗΓΟΡΙΑ 8	Εξαμεθυλενοδιαμίνη λύση	   ", "")
clv2.AddTextItem("1784	ΚΑΤΗΓΟΡΙΑ 8	Hexyltrichlorosilane	   ", "")
clv2.AddTextItem("1786	ΚΑΤΗΓΟΡΙΑ 8	Υδροφθορικό οξύ και θειικό οξύ μείγματα	", "")   
clv2.AddTextItem("1787	ΚΑΤΗΓΟΡΙΑ 8	Υδροϊώδιο	   ", "")
clv2.AddTextItem("1788	ΚΑΤΗΓΟΡΙΑ 8	Υδροβρωμικό οξύ , με περισσότερο από το 49 τοις εκατό υδροβρωμικό οξύ ", "")
clv2.AddTextItem("1789	ΚΑΤΗΓΟΡΙΑ 8	Υδροχλωρικό οξύ	   ", "")
clv2.AddTextItem("1790	ΚΑΤΗΓΟΡΙΑ 8	Υδροφθορικό οξύ , με περισσότερο από 60 τοις εκατό  υδροφθορικό οξύ	   ", "")
clv2.AddTextItem("1791	ΚΑΤΗΓΟΡΙΑ 8	Υποχλωριώδες λύσεις	  ", "")
clv2.AddTextItem("1792	ΚΑΤΗΓΟΡΙΑ 8	Μονοχλωριούχο ιώδιο , στερεά	", "")   
clv2.AddTextItem("1793	ΚΑΤΗΓΟΡΙΑ 8	Ισοπροπυλ φωσφορικό οξύ	   ", "")
clv2.AddTextItem("1794	ΚΑΤΗΓΟΡΙΑ 8	Θειικός μόλυβδος ", "")
clv2.AddTextItem("1796	ΚΑΤΗΓΟΡΙΑ 8	Νίτρωσης οξύ μίγματα", "")
clv2.AddTextItem("1798	ΚΑΤΗΓΟΡΙΑ 8	Nitrohydrochloric οξύ", "")	   
clv2.AddTextItem("1799	ΚΑΤΗΓΟΡΙΑ 8	Nonyltrichlorosilane	   ", "")
 clv2.AddTextItem("1800	ΚΑΤΗΓΟΡΙΑ 8	Octadecyltrichlorosilane	 ", "")


End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub


Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
