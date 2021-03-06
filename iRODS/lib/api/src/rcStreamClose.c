/**
 * @file  rcStreamClose.c
 *
 */

/* This is script-generated code.  */ 
/* See streamClose.h for a description of this API call.*/

#include "streamClose.h"

/**
 * \fn rcStreamClose (rcComm_t *conn, fileCloseInp_t *fileCloseInp)
 *
 * \brief The output of rcExecCmd API can be a stream. rcStreamRead is used 
 * read the stream and this API is used to close the stream.
 *
 * \user client
 *
 * \category misc operations
 *
 * \since 1.0
 *
 * \author  Mike Wan
 * \date    2007
 *
 * \remark none
 *
 * \note none
 *
 * \usage
 * Close a stream from a rcExecCmd call.
 * \n int status;
 * \n fileCloseInp_t fileCloseInp;
 * \n fileReadInp_t streamReadInp;
 * \n bytesBuf_t *streamReadOutBBuf;
 * \n execCmd_t execCmd;
 * \n execCmdOut_t *execCmdOut = NULL;
 * \n 
 * \n ...... do the preprocessing for the rcExecCmd call.
 * \n status = rcExecCmd (conn, &execCmd, &execCmdOut);
 * \n if (execCmdOut != NULL) {
 * \n    if (execCmdOut->status > 0) {
 * \n       # execCmdOut->status is a stream descriptor 
 * \n       bzero (&streamReadInp, sizeof (streamReadInp));
 * \n       streamReadOutBBuf = &execCmdOut->stdoutBuf;
 * \n       streamReadOutBBuf->buf = malloc (MAX_SZ_FOR_EXECMD_BUF);
 * \n       streamReadOutBBuf->len = streamReadInp.len = MAX_SZ_FOR_EXECMD_BUF;
 * \n       streamReadInp.fileInx = execCmdOut->status;
 * \n       while ((bytesRead = rcStreamRead (conn, &streamReadInp,
 * \n         streamReadOutBBuf)) > 0) {
 * \n          .... process the read data
 * \n       }
 * \n       streamCloseInp.fileInx = execCmdOut->status;
 * \n       rcStreamClose (conn, &streamCloseInp);
 * \n    }
 * \n }
 *
 * \param[in] conn - A rcComm_t connection handle to the server.
 * \param[in] fileCloseInp - Elements of fileCloseInp_t used :
 *    \li int \b fileInx - The stream index to close.
 * \return integer
 * \retval 0 on success
 * \sideeffect none
 * \pre none
 * \post none
 * \sa none
 * \bug  no known bugs
**/

int
rcStreamClose (rcComm_t *conn, fileCloseInp_t *fileCloseInp)
{
    int status;
    status = procApiRequest (conn, STREAM_CLOSE_AN, fileCloseInp, NULL, 
        (void **) NULL, NULL);

    return (status);
}
