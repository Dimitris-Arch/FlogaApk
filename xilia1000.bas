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

'Dim AdView1 As AdView




	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")
    

'AdView1.Initialize("Ad", "ca-app-pub-6889311870331566/2287503739")
'	 Activity.AddView(AdView1, 0dip, 100%y - 50dip, 100%x, 50dip)
 '  AdView1.LoadAd
		
		
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

 
clv2.AddTextItem("1902	ΚΑΤΗΓΟΡΙΑ 8	Δι-ισοοκτυλο φωσφορικό οξύ	   " ,"") 
clv2.AddTextItem("1903	ΚΑΤΗΓΟΡΙΑ 8	Απολυμαντικά , υγρά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("1905	ΚΑΤΗΓΟΡΙΑ 8	Ιλύος, οξύ	   " ,"") 
clv2.AddTextItem("1906	ΚΑΤΗΓΟΡΙΑ 8	Ιλύος, οξύ	   " ,"") 
clv2.AddTextItem("1907	ΚΑΤΗΓΟΡΙΑ 8	Νατράσβεστος 	   " ,"") 
clv2.AddTextItem("1908	ΚΑΤΗΓΟΡΙΑ 8	Χλωριώδες διάλυμα	   " ,"") 
clv2.AddTextItem("1910	ΚΑΤΗΓΟΡΙΑ 8	Οξείδιο  ασβεστίου	   " ,"") 
clv2.AddTextItem("1911	ΚΑΤΗΓΟΡΙΑ 2	Διβοράνιο , συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1912	ΚΑΤΗΓΟΡΙΑ 2	Χλωριούχο μεθύλιο και χλωριούχο μεθυλένιο μείγματα	" ,"")    
clv2.AddTextItem("1913	ΚΑΤΗΓΟΡΙΑ 2	Νέον , ψυγείο υγρού κρυογονική υγρό	   " ,"") 
clv2.AddTextItem("1914	ΚΑΤΗΓΟΡΙΑ 3	Βουτύλιο προπιονικές	   " ,"") 
clv2.AddTextItem("1915	ΚΑΤΗΓΟΡΙΑ 3	Κυκλοεξανόνη	   " ,"") 
clv2.AddTextItem("1916	ΚΑΤΗΓΟΡΙΑ 6.1	Διχλωροδιαιθυλαιθέρα	   " ,"") 
clv2.AddTextItem("1917	ΚΑΤΗΓΟΡΙΑ 3	Ακρυλικού αιθυλεστέρα " ,"") 
clv2.AddTextItem("1918	ΚΑΤΗΓΟΡΙΑ 3	Ισοπροπυλοβενζολο	   " ,"") 
clv2.AddTextItem("1919	ΚΑΤΗΓΟΡΙΑ 3	Ακρυλικό μεθύλιο", "")
clv2.AddTextItem("1920	ΚΑΤΗΓΟΡΙΑ 3	Εννεανίων	   " ,"") 
clv2.AddTextItem("1921	ΚΑΤΗΓΟΡΙΑ 3	ΠΡΟΠΥΛΕΝΙΜΙΝΗ , αναστέλλεται	   " ,"") 
clv2.AddTextItem("1922	ΚΑΤΗΓΟΡΙΑ 3	Πυρρολιδίνη	   " ,"") 
clv2.AddTextItem("1923	ΚΑΤΗΓΟΡΙΑ 4.2	Διθειονώδης ασβέστιο ή όξινο θειώδες ασβέστιο	   " ,"") 
clv2.AddTextItem("1928	ΚΑΤΗΓΟΡΙΑ 4.3	Βρωμιούχο μαγνήσιο μεθύλιο σε αιθυλαιθέρα	   " ,"") 
clv2.AddTextItem("1929	ΚΑΤΗΓΟΡΙΑ 4.2	Διθειονώδης κάλιο ή όξινο θειώδες κάλιο	   " ,"") 
clv2.AddTextItem("1931	ΚΑΤΗΓΟΡΙΑ 9	Διθειονώδης ψευδάργυρος ή υδροσουλφίτη ψευδάργυρος	 " ,"")   
clv2.AddTextItem("1932	ΚΑΤΗΓΟΡΙΑ 4.2	Ζιρκόνιο απορρίμματα	   " ,"") 
clv2.AddTextItem("1935	ΚΑΤΗΓΟΡΙΑ 6.1	Το κυάνιο " ,"") 
clv2.AddTextItem("1938	ΚΑΤΗΓΟΡΙΑ 8	Βρωμοοξικού οξέος , διάλυμα ή βρωμοξεικόοξύ, στερεά	" ,"")    
clv2.AddTextItem("1939	ΚΑΤΗΓΟΡΙΑ 8	Φωσφόρου οξυβρωμίδιο	   " ,"") 
clv2.AddTextItem("1940	ΚΑΤΗΓΟΡΙΑ 8	Thioglycolic οξύ	   " ,"") 
clv2.AddTextItem("1941	ΚΑΤΗΓΟΡΙΑ 9	Διβρωμοδιφθορομεθάνιο , R12B2	   " ,"") 
clv2.AddTextItem("1942	ΚΑΤΗΓΟΡΙΑ 5.1	Το νιτρικό αμμώνιο " ,"") 
clv2.AddTextItem("1944	ΚΑΤΗΓΟΡΙΑ 4.1	Σπιρτα " ,"") 	   
clv2.AddTextItem("1945	ΚΑΤΗΓΟΡΙΑ 4.1	Σπίρτα, κερί, Vesta	   " ,"") 
clv2.AddTextItem("1950	ΚΑΤΗΓΟΡΙΑ 2	Τα αερολύματα , διαβρωτικά, Ομάδα συσκευασίας ΙΙ ή ΙΙΙ " ,"")   
clv2.AddTextItem("1951	ΚΑΤΗΓΟΡΙΑ 2	Αργό , ψυγείο υγρού κρυογονική υγρό	   " ,"") 
clv2.AddTextItem("1952	ΚΑΤΗΓΟΡΙΑ 2	Οξείδιο  αιθυλενίου   " ,"") 
clv2.AddTextItem("1953	ΚΑΤΗΓΟΡΙΑ 2	Συμπιεσμένο αέριο , τοξικό, εύφλεκτο,   " ,"") 
clv2.AddTextItem("1954	ΚΑΤΗΓΟΡΙΑ 2	Συμπιεσμένο αέριο, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("1955	ΚΑΤΗΓΟΡΙΑ 2	Συμπιεσμένο αέριο, τοξικά, 	   " ,"") 
clv2.AddTextItem("1956	ΚΑΤΗΓΟΡΙΑ 2	Συμπιεσμένο αέριο, 	   " ,"") 
clv2.AddTextItem("1957	ΚΑΤΗΓΟΡΙΑ 2	Το δευτέριο , συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1958	ΚΑΤΗΓΟΡΙΑ 2	Διχλωρο--τετραφθοροαιθάνιο ή το ψυκτικό αέριο R 114	 " ,"")   
clv2.AddTextItem("1959	ΚΑΤΗΓΟΡΙΑ 2	1,1-διφθοραιθένιο ή ψυκτικό αέριο R 1132a	   " ,"") 
clv2.AddTextItem("1961	ΚΑΤΗΓΟΡΙΑ 2	Αιθάνιο , κατεψυγμένο, υγρό	   " ,"") 
clv2.AddTextItem("1962	ΚΑΤΗΓΟΡΙΑ 2	Αιθυλένιο , συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1963	ΚΑΤΗΓΟΡΙΑ 2	Ήλιο , ψυγείο υγρού κρυογονική υγρό	   " ,"") 
clv2.AddTextItem("1964	ΚΑΤΗΓΟΡΙΑ 2	Υδρογονανθράκων αέριο μίγμα, συμπιέζεται, 	   " ,"") 
clv2.AddTextItem("1965	ΚΑΤΗΓΟΡΙΑ 2	Μείγματα αερίων υδρογονανθράκων, υγροποιημένων, 	   " ,"") 
clv2.AddTextItem("1966	ΚΑΤΗΓΟΡΙΑ 2	Το υγρό υδρογόνο , κατεψυγμένου υγρού κρυογονική υγρό	   " ,"") 
clv2.AddTextItem("1967	ΚΑΤΗΓΟΡΙΑ 2	Εντομοκτόνο αέρια, τοξικά, 	   " ,"") 
clv2.AddTextItem("1968	ΚΑΤΗΓΟΡΙΑ 2	Εντομοκτόνα αέρια, 	   " ,"") 
clv2.AddTextItem("1969	ΚΑΤΗΓΟΡΙΑ 2	Ισοβουτάνιο βλέπε επίσης αέρια πετρελαίου, υγροποιημένα	   " ,"") 
clv2.AddTextItem("1970	ΚΑΤΗΓΟΡΙΑ 2	Krypton , ψυγείο υγρού κρυογονική υγρό	   " ,"") 
clv2.AddTextItem("1971	ΚΑΤΗΓΟΡΙΑ 2	Το μεθάνιο , συμπιεσμένα ή φυσικό αέριο 	" ,"")    
clv2.AddTextItem("1972	ΚΑΤΗΓΟΡΙΑ 2	Το μεθάνιο,κρυογονικο	   " ,"") 
clv2.AddTextItem("1973	ΚΑΤΗΓΟΡΙΑ 2	Χλωροδιφθορομεθάνιο και χλωροπενταφθοροαιθανίου" ,"") 
clv2.AddTextItem("1974	ΚΑΤΗΓΟΡΙΑ 2	Chlorodifluorobromomethane ή ψυκτικό αέριο R 12B1	" ,"")    
clv2.AddTextItem("1975	ΚΑΤΗΓΟΡΙΑ 2	Το μονοξείδιο  αζώτου	   " ,"") 
clv2.AddTextItem("1976	ΚΑΤΗΓΟΡΙΑ 2	Οκταφθοροκυκλοβουτάνιο , ή ψυκτικό αέριο RC 318	   " ,"") 
clv2.AddTextItem("1977	ΚΑΤΗΓΟΡΙΑ 2	Άζωτο , κατεψυγμένο, υγρό κρυογονικo υγρό	   " ,"") 
clv2.AddTextItem("1978	ΚΑΤΗΓΟΡΙΑ 2	Προπάνιο Δείτε επίσης αέρια πετρελαίου, υγροποιημένα	   " ,"") 
clv2.AddTextItem("1979	ΚΑΤΗΓΟΡΙΑ 2	Ευγενή αέρια, μείγματα, συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1980	ΚΑΤΗΓΟΡΙΑ 2	Ευγενή αέρια και μίγματα οξυγόνου, συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1981	ΚΑΤΗΓΟΡΙΑ 2	Ευγενή αέρια και μείγματα αζώ, συμπιεσμένο	   " ,"") 
clv2.AddTextItem("1982	ΚΑΤΗΓΟΡΙΑ 2	Τετραφθορομεθάνιο , συμπιεσμένα ή ψυκτικό αέριο R 14	" ,"")    
clv2.AddTextItem("1983	ΚΑΤΗΓΟΡΙΑ 2	Χλωρο-τριφθοροαιθάνιο ή ψυκτικό αέριο R 133α	   " ,"") 
clv2.AddTextItem("1984	ΚΑΤΗΓΟΡΙΑ 2	Τριφθορομεθάνη ή ψυκτικό αέριο R 23	   " ,"") 
clv2.AddTextItem("1986	ΚΑΤΗΓΟΡΙΑ 3	Αλκοόλες , εύφλεκτες, τοξικές, 	   " ,"") 
clv2.AddTextItem("1987	ΚΑΤΗΓΟΡΙΑ 3	Αλκοόλες, 	   " ,"") 
clv2.AddTextItem("1988	ΚΑΤΗΓΟΡΙΑ 3	Αλδεΰδες , εύφλεκτες, τοξικές, 	   " ,"") 
clv2.AddTextItem("1989	ΚΑΤΗΓΟΡΙΑ 3	Αλδεΰδες, 	   " ,"") 
clv2.AddTextItem("1990	ΚΑΤΗΓΟΡΙΑ 9	Βενζαλδεϋδη	   " ,"") 
clv2.AddTextItem("1991	ΚΑΤΗΓΟΡΙΑ 3	Χλωροπρενίου , αναστέλλεται	   " ,"") 
clv2.AddTextItem("1992	ΚΑΤΗΓΟΡΙΑ 3	Εύφλεκτα υγρά, τοξικά, 	   " ,"") 
clv2.AddTextItem("1993	ΚΑΤΗΓΟΡΙΑ 3	Εύφλεκτα υγρά, 	   " ,"") 
clv2.AddTextItem("1994	ΚΑΤΗΓΟΡΙΑ 6.1	Πεντακαρβονυλσιδήρου	" ,"")    
clv2.AddTextItem("1999	ΚΑΤΗΓΟΡΙΑ 3	Πίσσες , υγρές, συμπεριλαμβανομένων δρόμος άσφαλτος και λάδια  " ,"") 
clv2.AddTextItem("2000	ΚΑΤΗΓΟΡΙΑ 4.1	Ταρταρούγα , σε μπλοκ, ράβδους, κυλίνδρους, φύλλα, σωλήνες" ,"") 

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
