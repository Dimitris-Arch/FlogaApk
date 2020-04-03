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

 
clv2.AddTextItem("2301	Κατηγορία 3	Κατηγορία 2-μεθυλοφουραν	   " ,"")
clv2.AddTextItem("2302	Κατηγορία 3	Κατηγορία 5-μεθυλεξαν-Κατηγορία 2-όνη	    " ,"")
clv2.AddTextItem("2303	Κατηγορία 3	Isopropenylbenzene	    " ,"")
clv2.AddTextItem("2304	Κατηγορία 4.1	Ναφθαλίνης , λιωμένο	 " ,"")   
clv2.AddTextItem("2305	Κατηγορία 8	Νιτροβενζολοσουλφονικός οξύ	    " ,"")
clv2.AddTextItem("2306	Κατηγορία 6.1	Nitrobenzotrifluorides , υγρό	    " ,"")
clv2.AddTextItem("2307	Κατηγορία 6.1	Κατηγορία 3-νιτρο-Κατηγορία 4-χλωροβενζολίου	    " ,"")
clv2.AddTextItem("2308	Κατηγορία 8	Nitrosylsulfuric οξύ	    " ,"")
clv2.AddTextItem("2309	Κατηγορία 3	Οκταδιενίου	    " ,"")
clv2.AddTextItem("2310	Κατηγορία 3	Πεντανο-Κατηγορία 2,Κατηγορία 4-διόνη	    " ,"")
clv2.AddTextItem("2311	Κατηγορία 6.1	Φαινετιδίνες	    " ,"")
clv2.AddTextItem("2312	Κατηγορία 6.1	Η φαινόλη , λιωμένο	    " ,"")
clv2.AddTextItem("2313	Κατηγορία 3	Πικολινών	    " ,"")
clv2.AddTextItem("2315	Κατηγορία 9	Τα πολυχλωριωμένα διφαινύλια , υγρά	    " ,"")
clv2.AddTextItem("2316	Κατηγορία 6.1	Cuprocyanide νατρίου , στερεό	    " ,"")
clv2.AddTextItem("2317	Κατηγορία 6.1	Cuprocyanide νατρίου, διάλυμα	    " ,"")
clv2.AddTextItem("2318	Κατηγορία 4.2	Θειούχο νάτριο , με λιγότερο από 25 τοις εκατό νερό κρυστάλλωσης	    " ,"")
clv2.AddTextItem("2319	Κατηγορία 3	Τερπενίων υδρογονάνθρακες , ε.α.ο.	    " ,"")
clv2.AddTextItem("2320	Κατηγορία 8	Τετρααιθυλενοπενταμίνη	    " ,"")
clv2.AddTextItem("2321	Κατηγορία 6.1	Τριχλωροβενζόλια , υγρό	    " ,"")
clv2.AddTextItem("2322	Κατηγορία 6.1	Trichlorobutene	    " ,"")
clv2.AddTextItem("2323	Κατηγορία 3	Φωσφορώδους τριαιθυλίου	    " ,"")
clv2.AddTextItem("2324	Κατηγορία 3	Triisobutylene	    " ,"")
clv2.AddTextItem("2325	Κατηγορία 3	Κατηγορία 1,Κατηγορία 3,Κατηγορία 5-τριμεθυλβενζόλιο (μεσιτυλένιο)	    " ,"")
clv2.AddTextItem("2326	Κατηγορία 8	Trimethylcyclohexylamine	    " ,"")
clv2.AddTextItem("2327	Κατηγορία 8	Trimethylhexamethylenediamines	    " ,"")
clv2.AddTextItem("2328	Κατηγορία 6.1	Διισοκυανικό τριμεθυλοεξαμεθυλένιο	    " ,"")
clv2.AddTextItem("2329	Κατηγορία 3	Φωσφορώδες τριμεθύλιο	    " ,"")
clv2.AddTextItem("2330	Κατηγορία 3	Ενδεκάνιο	    " ,"")
clv2.AddTextItem("2331	Κατηγορία 8	Χλωριούχο ψευδάργυρο , άνυδρο	    " ,"")
clv2.AddTextItem("2332	Κατηγορία 3	Η ακεταλδεΰδη οξίμη	    " ,"")
clv2.AddTextItem("2333	Κατηγορία 3	Αλλυλεστέρα	    " ,"")
clv2.AddTextItem("2334	Κατηγορία 6.1	Αλυλαμίνη	    " ,"")
clv2.AddTextItem("2335	Κατηγορία 3	Αλλυλ αιθυλαιθέρα	    " ,"")
clv2.AddTextItem("2336	Κατηγορία 3	Αλλυλο μυρμηκικό	    " ,"")
clv2.AddTextItem("2337	Κατηγορία 6.1	Φαινυλ μερκαπτάνης	    " ,"")
clv2.AddTextItem("2338	Κατηγορία 3	Βενζοτριφθορίδιο	    " ,"")
clv2.AddTextItem("2339	Κατηγορία 3	Κατηγορία 2-βρωμοβουτάνιο	    " ,"")
clv2.AddTextItem("2340	Κατηγορία 3	Κατηγορία 2-βρωμοαιθυλ αιθυλ αιθέρα	    " ,"")
clv2.AddTextItem("2341	Κατηγορία 3	Κατηγορία 1-βρωμο-Κατηγορία 3-μεθυλοβουτάνιο	    " ,"")
clv2.AddTextItem("2342	Κατηγορία 3	Bromomethylpropanes	    " ,"")
clv2.AddTextItem("2343	Κατηγορία 3	Κατηγορία 2-Βρωμοπεντάνιο	    " ,"")
clv2.AddTextItem("2344	Κατηγορία 3	Bromopropanes	    " ,"")
clv2.AddTextItem("2345	Κατηγορία 3	Κατηγορία 3-Bromopropyne	    " ,"")
clv2.AddTextItem("2346	Κατηγορία 3	Βουτανιοδιόνη	    " ,"")
clv2.AddTextItem("2347	Κατηγορία 3	Βουτύλιο μερκαπτάνες	    " ,"")
clv2.AddTextItem("2348	Κατηγορία 3	Βουτύλιο ακρυλικών , αναστέλλεται	    " ,"")
clv2.AddTextItem("2350	Κατηγορία 3	Βουτυλο μεθυλο αιθέρας	 " ,"")   
clv2.AddTextItem("2351	Κατηγορία 3	Βουτύλιο νιτρώδη	    " ,"")
clv2.AddTextItem("2352	Κατηγορία 3	Βουτυλο βινυλαιθέρα " ,"")	   
clv2.AddTextItem("2353	Κατηγορία 3	Βουτυρυλο χλωρίδιο	    " ,"")
clv2.AddTextItem("2354	Κατηγορία 3	Χλωρομεθυλαιθυλαιθέρα	    " ,"")
clv2.AddTextItem("2356	Κατηγορία 3	Κατηγορία 2-χλωροπροπανίου	    " ,"")
clv2.AddTextItem("2357	Κατηγορία 8	Κυκλοεξυλαμίνη	    " ,"")
clv2.AddTextItem("2358	Κατηγορία 3	Κυκλοοκατετραενίου	    " ,"")
clv2.AddTextItem("2359	Κατηγορία 3	Διαλλυλαμίνης	    " ,"")
clv2.AddTextItem("2360	Κατηγορία 3	Διαλλυλαιθέρας	    " ,"")
clv2.AddTextItem("2361	Κατηγορία 3	Διϊσοβουτυλαμίνη	    " ,"")
clv2.AddTextItem("2362	Κατηγορία 3	Κατηγορία 1,Κατηγορία 1-διχλωροαιθάνιο	 " ,"")   
clv2.AddTextItem("2363	Κατηγορία 3	Αιθύλιο μερκαπτάνης	    " ,"")
clv2.AddTextItem("2364	Κατηγορία 3	n-προπυλο βενζόλιο	    " ,"")
clv2.AddTextItem("2366	Κατηγορία 3	Διαιθυλο ανθρακικό	    " ,"")
clv2.AddTextItem("2367	Κατηγορία 3	αλφα-μεθυλβαλεραλδεϋδη	    " ,"")
clv2.AddTextItem("2368	Κατηγορία 3	άλφα-πινένιο	    " ,"")
clv2.AddTextItem("2370	Κατηγορία 3	Κατηγορία 1-εξένιο	    " ,"")
clv2.AddTextItem("2371	Κατηγορία 3	Isopentenes	    " ,"")
clv2.AddTextItem("2372	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2-δι- (διμεθυλαμινο) αιθάνιο	    " ,"")
clv2.AddTextItem("2373	Κατηγορία 3	Διαιθοξυμεθάνιο	    " ,"")
clv2.AddTextItem("2374	Κατηγορία 3	Κατηγορία 3,Κατηγορία 3-Diethoxypropene	    " ,"")
clv2.AddTextItem("2375	Κατηγορία 3	Διαιθυλοσουλφίδιο	    " ,"")
clv2.AddTextItem("2376	Κατηγορία 3	Κατηγορία 2,Κατηγορία 3-διυδροπυραν	    " ,"")
clv2.AddTextItem("2377	Κατηγορία 3	Κατηγορία 1,Κατηγορία 1-διμεθοξυαιθάνιο	    " ,"")
clv2.AddTextItem("2378	Κατηγορία 3	Κατηγορία 2-Dimethylaminoacetonitrile	    " ,"")
clv2.AddTextItem("2379	Κατηγορία 3	Κατηγορία 1,Κατηγορία 3-διμεθυλβουτυλαμίνη	    " ,"")
clv2.AddTextItem("2380	Κατηγορία 3	Διμεθυλοδιαιθοξυσιλάνιο	    " ,"")
clv2.AddTextItem("2381	Κατηγορία 3	Διμεθυλο δισουλφίδιο	    " ,"")
clv2.AddTextItem("2382	Κατηγορία 6.1	Διμεθυλοϋδραζίνη , συμμετρική	    " ,"")
clv2.AddTextItem("2383	Κατηγορία 3	Διπροπυλαμίνης	    " ,"")
clv2.AddTextItem("2384	Κατηγορία 3	Δι-η-προπυλαιθέρα	    " ,"")
clv2.AddTextItem("2385	Κατηγορία 3	Αιθύλιο ισοβουτυρικό	    " ,"")
clv2.AddTextItem("2386	Κατηγορία 3	Κατηγορία 1-αιθυλοπιπεριδίνη	    " ,"")
clv2.AddTextItem("2387	Κατηγορία 3	ΦΘΟΡΟΒΕΝΖΙΝΗ	    " ,"")
clv2.AddTextItem("2388	Κατηγορία 3	Fluorotoluenes	    " ,"")
clv2.AddTextItem("2389	Κατηγορία 3.1	Φουράνη	    " ,"")
clv2.AddTextItem("2390	Κατηγορία 3	Κατηγορία 2-ιωδοβουτάνιο	    " ,"")
clv2.AddTextItem("2391	Κατηγορία 3	Iodomethylpropanes	    " ,"")
clv2.AddTextItem("2392	Κατηγορία 3	Iodopropanes	    " ,"")
clv2.AddTextItem("2393	Κατηγορία 3	Μυρμηκικός ισοβουτυλεστέρας	    " ,"")
clv2.AddTextItem("2394	Κατηγορία 3	Ισοβουτύλιο προπιονικό	    " ,"")
clv2.AddTextItem("2395	Κατηγορία 3	Ισοβουτυρυλοχλωρίδιο	    " ,"")
clv2.AddTextItem("2396	Κατηγορία 3	Methacrylaldehyde , αναστέλλεται	    " ,"")
clv2.AddTextItem("2397	Κατηγορία 3	Κατηγορία 3-μεθυλοβουταν-Κατηγορία 2-όνη	 " ,"")   
clv2.AddTextItem("2398	Κατηγορία 3	Μεθυλο-τριτ-βουτυλαιθέρα	    " ,"")
clv2.AddTextItem("2399	Κατηγορία 3	Κατηγορία 1-μεθυλοπιπεριδίνη	    " ,"")
clv2.AddTextItem("2400	Κατηγορία 3	Ισοβαλερικού μεθυλίου " ,"")

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
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
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
