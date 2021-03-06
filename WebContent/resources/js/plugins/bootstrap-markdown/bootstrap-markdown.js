!function($){"use strict";var Markdown=function(element,options){this.$ns='bootstrap-markdown'
this.$element=$(element)
this.$editable={el:null,type:null,attrKeys:[],attrValues:[],content:null}
this.$options=$.extend(true,{},$.fn.markdown.defaults,options)
this.$oldContent=null
this.$isPreview=false
this.$editor=null
this.$textarea=null
this.$handler=[]
this.$callback=[]
this.$nextTab=[]
this.showEditor()}
Markdown.prototype={constructor:Markdown,__alterButtons:function(name,alter){var handler=this.$handler,isAll=(name=='all'),that=this
$.each(handler,function(k,v){var halt=true
if(isAll){halt=false}else{halt=v.indexOf(name)<0}
if(halt==false){alter(that.$editor.find('button[data-handler="'+v+'"]'))}})},__buildButtons:function(buttonsArray,container){var i,ns=this.$ns,handler=this.$handler,callback=this.$callback
for(i=0;i<buttonsArray.length;i++){var y,btnGroups=buttonsArray[i]
for(y=0;y<btnGroups.length;y++){var z,buttons=btnGroups[y].data,btnGroupContainer=$('<div/>',{'class':'btn-group'})
for(z=0;z<buttons.length;z++){var button=buttons[z],buttonToggle='',buttonHandler=ns+'-'+button.name,buttonIcon=button.icon instanceof Object?button.icon[this.$options.iconlibrary]:button.icon,btnText=button.btnText?button.btnText:'',btnClass=button.btnClass?button.btnClass:'btn',tabIndex=button.tabIndex?button.tabIndex:'-1'
if(button.toggle==true){buttonToggle=' data-toggle="button"'}
btnGroupContainer.append('<button type="button" class="'
+btnClass
+' btn-default btn-sm" title="'
+button.title
+'" tabindex="'
+tabIndex
+'" data-provider="'
+ns
+'" data-handler="'
+buttonHandler
+'"'
+buttonToggle
+'><span class="'
+buttonIcon
+'"></span> '
+btnText
+'</button>')
handler.push(buttonHandler)
callback.push(button.callback)}
container.append(btnGroupContainer)}}
return container},__setListener:function(){var hasRows=typeof this.$textarea.attr('rows')!='undefined',maxRows=this.$textarea.val().split("\n").length>5?this.$textarea.val().split("\n").length:'5',rowsVal=hasRows?this.$textarea.attr('rows'):maxRows
this.$textarea.attr('rows',rowsVal)
this.$textarea.css('resize','none')
this.$textarea.on('focus',$.proxy(this.focus,this)).on('keypress',$.proxy(this.keypress,this)).on('keyup',$.proxy(this.keyup,this))
if(this.eventSupported('keydown')){this.$textarea.on('keydown',$.proxy(this.keydown,this))}
this.$textarea.data('markdown',this)},__handle:function(e){var target=$(e.currentTarget),handler=this.$handler,callback=this.$callback,handlerName=target.attr('data-handler'),callbackIndex=handler.indexOf(handlerName),callbackHandler=callback[callbackIndex]
$(e.currentTarget).focus()
callbackHandler(this)
if(handlerName.indexOf('cmdSave')<0){this.$textarea.focus()}
e.preventDefault()},showEditor:function(){var instance=this,textarea,ns=this.$ns,container=this.$element,originalHeigth=container.css('height'),originalWidth=container.css('width'),editable=this.$editable,handler=this.$handler,callback=this.$callback,options=this.$options,editor=$('<div/>',{'class':'md-editor',click:function(){instance.focus()}})
if(this.$editor==null){var editorHeader=$('<div/>',{'class':'md-header btn-toolbar'})
if(options.buttons.length>0){editorHeader=this.__buildButtons(options.buttons,editorHeader)}
if(options.additionalButtons.length>0){editorHeader=this.__buildButtons(options.additionalButtons,editorHeader)}
editor.append(editorHeader)
if(container.is('textarea')){container.before(editor)
textarea=container
textarea.addClass('md-input')
editor.append(textarea)}else{var rawContent=(typeof toMarkdown=='function')?toMarkdown(container.html()):container.html(),currentContent=$.trim(rawContent)
textarea=$('<textarea/>',{'class':'md-input','val':currentContent})
editor.append(textarea)
editable.el=container
editable.type=container.prop('tagName').toLowerCase()
editable.content=container.html()
$(container[0].attributes).each(function(){editable.attrKeys.push(this.nodeName)
editable.attrValues.push(this.nodeValue)})
container.replaceWith(editor)}
if(options.savable){var editorFooter=$('<div/>',{'class':'md-footer'}),saveHandler='cmdSave'
handler.push(saveHandler)
callback.push(options.onSave)
editorFooter.append('<button class="btn btn-success" data-provider="'
+ns
+'" data-handler="'
+saveHandler
+'"><i class="icon icon-white icon-ok"></i> Save</button>')
editor.append(editorFooter)}
$.each(['height','width'],function(k,attr){if(options[attr]!='inherit'){if(jQuery.isNumeric(options[attr])){editor.css(attr,options[attr]+'px')}else{editor.addClass(options[attr])}}})
this.$editor=editor
this.$textarea=textarea
this.$editable=editable
this.$oldContent=this.getContent()
this.__setListener()
this.$editor.attr('id',(new Date).getTime())
this.$editor.on('click','[data-provider="bootstrap-markdown"]',$.proxy(this.__handle,this))}else{this.$editor.show()}
if(options.autofocus){this.$textarea.focus()
this.$editor.addClass('active')}
options.onShow(this)
return this},showPreview:function(){var options=this.$options,callbackContent=options.onPreview(this),container=this.$textarea,afterContainer=container.next(),replacementContainer=$('<div/>',{'class':'md-preview','data-provider':'markdown-preview'}),content
this.$isPreview=true
this.disableButtons('all').enableButtons('cmdPreview')
if(typeof callbackContent=='string'){content=callbackContent}else{var val=container.val();if(typeof markdown=='object'){content=markdown.toHTML(val);}else if(typeof marked=='function'){content=marked(val);}else{content=val;}}
replacementContainer.html(content)
if(afterContainer&&afterContainer.attr('class')=='md-footer'){replacementContainer.insertBefore(afterContainer)}else{container.parent().append(replacementContainer)}
container.hide()
replacementContainer.data('markdown',this)
return this},hidePreview:function(){this.$isPreview=false
var container=this.$editor.find('div[data-provider="markdown-preview"]')
container.remove()
this.enableButtons('all')
this.$textarea.show()
this.__setListener()
return this},isDirty:function(){return this.$oldContent!=this.getContent()},getContent:function(){return this.$textarea.val()},setContent:function(content){this.$textarea.val(content)
return this},findSelection:function(chunk){var content=this.getContent(),startChunkPosition
if(startChunkPosition=content.indexOf(chunk),startChunkPosition>=0&&chunk.length>0){var oldSelection=this.getSelection(),selection
this.setSelection(startChunkPosition,startChunkPosition+chunk.length)
selection=this.getSelection()
this.setSelection(oldSelection.start,oldSelection.end)
return selection}else{return null}},getSelection:function(){var e=this.$textarea[0]
return(('selectionStart'in e&&function(){var l=e.selectionEnd- e.selectionStart
return{start:e.selectionStart,end:e.selectionEnd,length:l,text:e.value.substr(e.selectionStart,l)}})||function(){return null})()},setSelection:function(start,end){var e=this.$textarea[0]
return(('selectionStart'in e&&function(){e.selectionStart=start
e.selectionEnd=end
return})||function(){return null})()},replaceSelection:function(text){var e=this.$textarea[0]
return(('selectionStart'in e&&function(){e.value=e.value.substr(0,e.selectionStart)+ text+ e.value.substr(e.selectionEnd,e.value.length)
e.selectionStart=e.value.length
return this})||function(){e.value+=text
return jQuery(e)})()},getNextTab:function(){if(this.$nextTab.length==0){return null}else{var nextTab,tab=this.$nextTab.shift()
if(typeof tab=='function'){nextTab=tab()}else if(typeof tab=='object'&&tab.length>0){nextTab=tab}
return nextTab}},setNextTab:function(start,end){if(typeof start=='string'){var that=this
this.$nextTab.push(function(){return that.findSelection(start)})}else if(typeof start=='numeric'&&typeof end=='numeric'){var oldSelection=this.getSelection()
this.setSelection(start,end)
this.$nextTab.push(this.getSelection())
this.setSelection(oldSelection.start,oldSelection.end)}
return},enableButtons:function(name){var alter=function(el){el.removeAttr('disabled')}
this.__alterButtons(name,alter)
return this},disableButtons:function(name){var alter=function(el){el.attr('disabled','disabled')}
this.__alterButtons(name,alter)
return this},eventSupported:function(eventName){var isSupported=eventName in this.$element
if(!isSupported){this.$element.setAttribute(eventName,'return;')
isSupported=typeof this.$element[eventName]==='function'}
return isSupported},keydown:function(e){this.suppressKeyPressRepeat=~$.inArray(e.keyCode,[40,38,9,13,27])
this.keyup(e)},keypress:function(e){if(this.suppressKeyPressRepeat)return
this.keyup(e)},keyup:function(e){var blocked=false
switch(e.keyCode){case 40:case 38:case 16:case 17:case 18:break
case 9:var nextTab
if(nextTab=this.getNextTab(),nextTab!=null){var that=this
setTimeout(function(){that.setSelection(nextTab.start,nextTab.end)},500)
blocked=true}else{var cursor=this.getSelection()
if(cursor.start==cursor.end&&cursor.end==this.getContent().length){blocked=false}else{this.setSelection(this.getContent().length,this.getContent().length)
blocked=true}}
break
case 13:case 27:blocked=false
break
default:blocked=false}
if(blocked){e.stopPropagation()
e.preventDefault()}},focus:function(e){var options=this.$options,isHideable=options.hideable,editor=this.$editor
editor.addClass('active')
$(document).find('.md-editor').each(function(){if($(this).attr('id')!=editor.attr('id')){var attachedMarkdown
if(attachedMarkdown=$(this).find('textarea').data('markdown'),attachedMarkdown==null){attachedMarkdown=$(this).find('div[data-provider="markdown-preview"]').data('markdown')}
if(attachedMarkdown){attachedMarkdown.blur()}}})
options.onFocus(this);return this},blur:function(e){var options=this.$options,isHideable=options.hideable,editor=this.$editor,editable=this.$editable
if(editor.hasClass('active')||this.$element.parent().length==0){editor.removeClass('active')
if(isHideable){if(editable.el!=null){var oldElement=$('<'+editable.type+'/>'),content=this.getContent(),currentContent=(typeof markdown=='object')?markdown.toHTML(content):content
$(editable.attrKeys).each(function(k,v){oldElement.attr(editable.attrKeys[k],editable.attrValues[k])})
oldElement.html(currentContent)
editor.replaceWith(oldElement)}else{editor.hide()}}
options.onBlur(this)}
return this}}
var old=$.fn.markdown
$.fn.markdown=function(option){return this.each(function(){var $this=$(this),data=$this.data('markdown'),options=typeof option=='object'&&option
if(!data)$this.data('markdown',(data=new Markdown(this,options)))})}
$.fn.markdown.defaults={autofocus:false,hideable:false,savable:false,width:'inherit',height:'inherit',iconlibrary:'glyph',buttons:[[{name:'groupFont',data:[{name:'cmdBold',title:'Bold',icon:{glyph:'glyphicon glyphicon-bold',fa:'fa fa-bold'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent()
if(selected.length==0){chunk='strong text'}else{chunk=selected.text}
if(content.substr(selected.start-2,2)=='**'&&content.substr(selected.end,2)=='**'){e.setSelection(selected.start-2,selected.end+2)
e.replaceSelection(chunk)
cursor=selected.start-2}else{e.replaceSelection('**'+chunk+'**')
cursor=selected.start+2}
e.setSelection(cursor,cursor+chunk.length)}},{name:'cmdItalic',title:'Italic',icon:{glyph:'glyphicon glyphicon-italic',fa:'fa fa-italic'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent()
if(selected.length==0){chunk='emphasized text'}else{chunk=selected.text}
if(content.substr(selected.start-1,1)=='*'&&content.substr(selected.end,1)=='*'){e.setSelection(selected.start-1,selected.end+1)
e.replaceSelection(chunk)
cursor=selected.start-1}else{e.replaceSelection('*'+chunk+'*')
cursor=selected.start+1}
e.setSelection(cursor,cursor+chunk.length)}},{name:'cmdHeading',title:'Heading',icon:{glyph:'glyphicon glyphicon-header',fa:'fa fa-font'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent(),pointer,prevChar
if(selected.length==0){chunk='heading text'}else{chunk=selected.text+'\n';}
if((pointer=4,content.substr(selected.start-pointer,pointer)=='### ')||(pointer=3,content.substr(selected.start-pointer,pointer)=='###')){e.setSelection(selected.start-pointer,selected.end)
e.replaceSelection(chunk)
cursor=selected.start-pointer}else if(selected.start>0&&(prevChar=content.substr(selected.start-1,1),!!prevChar&&prevChar!='\n')){e.replaceSelection('\n\n### '+chunk)
cursor=selected.start+6}else{e.replaceSelection('### '+chunk)
cursor=selected.start+4}
e.setSelection(cursor,cursor+chunk.length)}}]},{name:'groupLink',data:[{name:'cmdUrl',title:'URL/Link',icon:{glyph:'glyphicon glyphicon-globe',fa:'fa fa-globe'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent(),link
if(selected.length==0){chunk='enter link description here'}else{chunk=selected.text}
link=prompt('Insert Hyperlink','http://')
if(link!=null&&link!=''&&link!='http://'){e.replaceSelection('['+chunk+']('+link+')')
cursor=selected.start+1
e.setSelection(cursor,cursor+chunk.length)}}},{name:'cmdImage',title:'Image',icon:{glyph:'glyphicon glyphicon-picture',fa:'fa fa-picture-o'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent(),link
if(selected.length==0){chunk='enter image description here'}else{chunk=selected.text}
link=prompt('Insert Image Hyperlink','http://')
if(link!=null){e.replaceSelection('!['+chunk+']('+link+' "enter image title here")')
cursor=selected.start+2
e.setNextTab('enter image title here')
e.setSelection(cursor,cursor+chunk.length)}}}]},{name:'groupMisc',data:[{name:'cmdList',title:'List',icon:{glyph:'glyphicon glyphicon-list',fa:'fa fa-list'},callback:function(e){var chunk,cursor,selected=e.getSelection(),content=e.getContent()
if(selected.length==0){chunk='list text here'
e.replaceSelection('- '+chunk)
cursor=selected.start+2}else{if(selected.text.indexOf('\n')<0){chunk=selected.text
e.replaceSelection('- '+chunk)
cursor=selected.start+2}else{var list=[]
list=selected.text.split('\n')
chunk=list[0]
$.each(list,function(k,v){list[k]='- '+v})
e.replaceSelection('\n\n'+list.join('\n'))
cursor=selected.start+4}}
e.setSelection(cursor,cursor+chunk.length)}}]},{name:'groupUtil',data:[{name:'cmdPreview',toggle:true,title:'Preview',btnText:'Preview',btnClass:'btn btn-primary btn-sm',icon:{glyph:'glyphicon glyphicon-search',fa:'fa fa-search'},callback:function(e){var isPreview=e.$isPreview,content
if(isPreview==false){e.showPreview()}else{e.hidePreview()}}}]}]],additionalButtons:[],onShow:function(e){},onPreview:function(e){},onSave:function(e){},onBlur:function(e){},onFocus:function(e){},}
$.fn.markdown.Constructor=Markdown
$.fn.markdown.noConflict=function(){$.fn.markdown=old
return this}
var initMarkdown=function(el){var $this=el
if($this.data('markdown')){$this.data('markdown').showEditor()
return}
$this.markdown($this.data())}
var analyzeMarkdown=function(e){var blurred=false,el,$docEditor=$(e.currentTarget)
if((e.type=='focusin'||e.type=='click')&&$docEditor.length==1&&typeof $docEditor[0]=='object'){el=$docEditor[0].activeElement
if(!$(el).data('markdown')){if(typeof $(el).parent().parent().parent().attr('class')=="undefined"||$(el).parent().parent().parent().attr('class').indexOf('md-editor')<0){if(typeof $(el).parent().parent().attr('class')=="undefined"||$(el).parent().parent().attr('class').indexOf('md-editor')<0){blurred=true}}else{blurred=false}}
if(blurred){$(document).find('.md-editor').each(function(){var parentMd=$(el).parent()
if($(this).attr('id')!=parentMd.attr('id')){var attachedMarkdown
if(attachedMarkdown=$(this).find('textarea').data('markdown'),attachedMarkdown==null){attachedMarkdown=$(this).find('div[data-provider="markdown-preview"]').data('markdown')}
if(attachedMarkdown){attachedMarkdown.blur()}}})}
e.stopPropagation()}}
$(document).on('click.markdown.data-api','[data-provide="markdown-editable"]',function(e){initMarkdown($(this))
e.preventDefault()}).on('click',function(e){analyzeMarkdown(e)}).on('focusin',function(e){analyzeMarkdown(e)}).ready(function(){$('textarea[data-provide="markdown"]').each(function(){initMarkdown($(this))})})}(window.jQuery);